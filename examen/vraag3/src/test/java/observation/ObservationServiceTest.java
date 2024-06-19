package observation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import java.util.List;

class ObservationServiceTest {

    @Test
    void findAllForBearBearExistsTest() {
        BearDAO bearDAO = mock(BearDAO.class);

        Bear bear = new Bear("Mnr. De Vos");
        when(bearDAO.findByName("Mnr. De Vos")).thenReturn(bear);

        Bear result = bearDAO.findByName("Mnr. De Vos");

        assertEquals(bear, result);
    }

    @Test
    void findAllForBearFindFilteredBearNameTest() {
        ObservationDAO observationDAO = mock(ObservationDAO.class);

        Bear bear = new Bear("Mnr. De Vos");
        when(observationDAO.findAll()).thenReturn(bear);

        assertEquals(bear, result);
    }
}