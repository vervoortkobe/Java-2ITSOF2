package banking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The BankApp class manages bank clients, allowing for operations such as
 * adding clients,
 * withdrawing amounts, and disabling clients.
 */
public class BankApp {
    private List<BankClient> clients;

    /**
     * Initializes a new instance of the BankApp class with an empty list of
     * clients.
     */
    public BankApp() {
        clients = new ArrayList<>();
    }

    /**
     * Retrieves the list of bank clients.
     *
     * @return a list of BankClient objects.
     */
    public List<BankClient> getClients() {
        return clients;
    }

    /**
     * Sets the list of bank clients.
     *
     * @param clients a list of BankClient objects to be managed by the app.
     */
    public void setClients(List<BankClient> clients) {
        this.clients = clients;
    }

    /**
     * Adds a new client to the bank.
     *
     * @param name         the name of the client.
     * @param amount       the initial amount in the client's account.
     * @param requiresCard whether the client requires a bank card.
     * @return the newly created BankClient object, or null if the name is null.
     */
    public BankClient addClient(String name, double amount, boolean requiresCard) {
        if (name == null) {
            return null;
        }
        BankClient client = new BankClient();
        client.setName(name);
        client.setAmount(amount);
        client.setState(ClientState.ACTIVE);
        if (requiresCard) {
            client.setCardId(getNewCardId());
        }
        clients.add(client);
        return client;
    }

    /**
     * Withdraws a specified amount from the client's account.
     *
     * @param name   the name of the client.
     * @param amount the amount to withdraw.
     * @return true if the withdrawal was successful, false otherwise.
     */
    public boolean withdrawAmount(String name, double amount) {
        for (BankClient client : clients) {
            if (client.getName().equals(name) && !ClientState.DISABLED.equals(client.getState())) {
                if (hasEnoughAmount(client, amount)) {
                    client.setAmount(client.getAmount() - amount);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the client has enough funds for a withdrawal.
     *
     * @param client the BankClient object.
     * @param amount the amount to withdraw.
     * @return true if the client has more than the specified amount, false
     *         otherwise.
     */
    public boolean hasEnoughAmount(BankClient client, double amount) {
        return client.getAmount() > amount;
    }

    /**
     * Disables a client, preventing any further transactions.
     *
     * @param name the name of the client to disable.
     */
    public void disableClient(String name) {
        for (BankClient client : clients) {
            if (client.getName().equals(name) && !ClientState.DISABLED.equals(client.getState())) {
                client.setState(ClientState.DISABLED);
                return;
            }
        }
    }

    /**
     * Generates a new unique card ID for a client.
     *
     * @return a string representing the new card ID.
     */
    private String getNewCardId() {
        return LocalDate.now().getYear() + "-" + UUID.randomUUID();
    }
}
