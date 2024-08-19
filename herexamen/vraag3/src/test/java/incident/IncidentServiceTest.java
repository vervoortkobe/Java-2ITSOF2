package incident;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;

class IncidentServiceTest {

    private IncidentService svc;

    @Mock
    private IncidentDAO dao = mock(IncidentDAO.class);

    @BeforeEach
    public void setUp() {
        svc = new IncidentService(dao);
        this.svc.addIncident("kimo", LocalDate.of(2024, 8, 19), AgressionType.INJURY, 1);
    }

    @Test
    void testAddIncident_paramsNull() {
        //params zijn null, dus moet null teruggeven
        assertNull(this.svc.addIncident(null, null, null, 0));
    }

    @Test
    void testAddIncident_dateInFuture() {
        //datum in toekomst, dus moet null teruggeven
        assertNull(this.svc.addIncident("kayla", LocalDate.now().plusDays(50), AgressionType.INJURY, 2));
    }

    @Test
    void testAddIncident_incidentAlreadyExists() {
        //kimo heeft al een incident
        assertFalse(this.svc.findAllIncidentsForBear("kimo").isEmpty());

        //kayla heeft nog geen incident
        assertTrue(this.svc.findAllIncidentsForBear("kayla").isEmpty());

        //we maken een nieuw incident voor kayla, dus dit moet het nieuwe incident teruggeven
        Incident nieuw = this.svc.addIncident("kayla", LocalDate.of(2023, 5, 23), AgressionType.MANSLAUGHTER, 2);
        assertEquals(nieuw.getBear(), "kayla");
        assertEquals(nieuw.getDate(), LocalDate.of(2023, 5, 23));
        assertEquals(nieuw.getAgressionType(), AgressionType.MANSLAUGHTER);
        assertEquals(nieuw.getVictims(), 2);
    }

    @Test
    void testAddIncident_incidentUpdateVictimsSuccess() {
        //kimo heeft al een incident
        assertFalse(this.svc.findAllIncidentsForBear("kimo").isEmpty());

        //kimo heeft nu 1 victim
        assertEquals(this.svc.findAllIncidentsForBear("kimo").get(0).getVictims(), 1);

        //we updaten kimo's incident naar 5 victims
        this.svc.addIncident("kimo", LocalDate.of(2024, 8, 19), AgressionType.INJURY, 5);

        //we kijken of de victims geupdatet werden van 1 naar 5
        assertEquals(this.svc.findAllIncidentsForBear("kimo").get(0).getVictims(), 1);
        assertEquals(this.svc.findAllIncidentsForBear("kimo").get(0).getVictims(), 5);
    }

    @Test
    void testRemoveIncident_incidentDoesntExist() {
        //beer bestaat niet, dus moet false teruggeven
        assertFalse(this.svc.removeIncident("kayla", LocalDate.of(2023, 5, 23), AgressionType.MANSLAUGHTER));
    }

    @Test
    void testRemoveIncident_DeleteExistingIncident() {
        //beer bestaat en wordt verwijderd, dus moet true teruggeven
        assertTrue(this.svc.removeIncident("kimo", LocalDate.of(2024, 8, 19), AgressionType.INJURY));
        //beer is verwijderd, dus moet lege list teruggeven
        assertEquals(this.svc.findAllIncidentsForBear("kimo"), new ArrayList<Incident>());
    }

    @Test
    void testFindAllIncidentsForBear_Success() {
        List<Incident> l = new ArrayList<>();
        l.add(new Incident("kimo", LocalDate.of(2024, 8, 19), AgressionType.INJURY, 1));

        //kimo zit in de lijst, dus moet de lijst van kimo teruggeven
        assertEquals(this.svc.findAllIncidentsForBear("kimo"), l);

        //kayla zit niet in de lijst, dus moet een lege lijst teruggeven
        assertEquals(this.svc.findAllIncidentsForBear(("kayla")), new ArrayList<Incident>());
    }
}