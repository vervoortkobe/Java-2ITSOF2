package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankAppTest {
    private BankApp bankApp;

    @BeforeEach
    public void setUp() {
        bankApp = new BankApp();
    }


    @Test
    void testGetClientsSuccess() {
        assertEquals(new ArrayList<>(), bankApp.getClients());
    }

    @Test
    void testSetClients_Success() {
        List clients = new ArrayList<BankClient>();
        BankClient c = new BankClient();
        c.setName("Jos Dover");
        c.setAmount(1000.00);
        c.setCardId("15151e");
        c.setState(ClientState.ACTIVE);
        assertNotNull(c);
        clients.add(c);
        assertTrue(clients.isEmpty());
        assertEquals(clients, bankApp.getClients());
    }

    @Test
    public void testAddClient_Success() {
        BankClient client = bankApp.addClient("John Doe", 1000.0, true);
        assertNotNull(client);
        assertEquals("John Doe", client.getName());
        assertEquals(1000.0, client.getAmount());
        assertNotNull(client.getCardId());
        assertEquals(ClientState.ACTIVE, client.getState());
    }

    @Test
    public void testWithdrawAmount_Success() {
        bankApp.addClient("Jane Doe", 1500.0, false);
        boolean result = bankApp.withdrawAmount("Jane Doe", 500.0);
        assertTrue(result);
        BankClient client = bankApp.getClients().get(0);
        assertEquals(1000.0, client.getAmount());
    }

    @Test
    public void testHasEnoughAmount_NotEnoughFunds() {
        bankApp.addClient("Jane Doe", 500.0, false);
        boolean result = bankApp.withdrawAmount("Jane Doe", 1000.0);
        assertFalse(result);
        BankClient client = bankApp.getClients().get(0);
        assertEquals(500.0, client.getAmount());
    }

    @Test
    public void testDisableClient_Success() {
        bankApp.addClient("John Doe", 1000.0, false);
        bankApp.disableClient("John Doe");
        BankClient client = bankApp.getClients().get(0);
        assertEquals(ClientState.DISABLED, client.getState());
    }

    @Test
    public void testDisableClient_NotExisting() {
        bankApp.addClient("John Doe", 1000.0, false);
        bankApp.disableClient("Jane Doe");
        BankClient client = bankApp.getClients().get(0);
        assertEquals(ClientState.ACTIVE, client.getState());
    }
}