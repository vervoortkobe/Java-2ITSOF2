package clinic;

import junit.framework.TestCase;
import model.Animal;
import model.AnimalType;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimalClinicV2Test extends TestCase {

    @Mock
    private AnimalClinicV2 clinic = mock(AnimalClinicV2.class);
    @Test
    public void testAddOneAnimal() {
        Animal test = new Animal("TestDier", AnimalType.DOG, "TestEigenaar");
        when(clinic.addAnimal(test)).thenReturn(clinic.countAnimals());
        int result = clinic.addAnimal(test);

        assertEquals(1, result);
    }
    @Test
    public void testAddTwoDifferentAnimals() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        Animal test1 = new Animal("TestDier", AnimalType.DOG, "TestEigenaar");
        Animal test2 = new Animal("Jos", AnimalType.CAT, "Jaak");
        int result1 = clinic.addAnimal(test1);
        int result2 = clinic.addAnimal(test2);

        assertEquals(1, result1);
        assertEquals(2, result2);
    }
    @Test
    public void testAddSameAnimals() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        Animal test1 = new Animal("TestDier", AnimalType.DOG, "TestEigenaar");
        int result1 = clinic.addAnimal(test1);
        int result2 = clinic.addAnimal(test1);

        assertEquals(1, result1);
        assertEquals(1, result2);
    }

    @Test
    public void testFindAnimal() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        Animal test1 = new Animal("TestDier", AnimalType.DOG, "TestEigenaar");
        clinic.addAnimal(test1);
        Animal result = clinic.findAnimal("TestDier", AnimalType.DOG);

        assertEquals(test1, result);
    }
    @Test
    public void testFindSameAnimal() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        Animal test1 = new Animal("TestDier", AnimalType.DOG, "TestEigenaar");
        Animal test2 = new Animal("Jos", AnimalType.CAT, "Jaak");
        clinic.addAnimal(test1);
        clinic.addAnimal(test2);
        Animal result = clinic.findAnimal("TestDier", AnimalType.DOG);

        assertEquals(test1, result);
    }
    @Test
    public void testFindOtherAnimal() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        Animal test1 = new Animal("TestDier", AnimalType.DOG, "TestEigenaar");
        Animal test2 = new Animal("Jos", AnimalType.CAT, "Jaak");
        clinic.addAnimal(test1);
        Animal result = clinic.findAnimal("Jos", AnimalType.CAT);

        assertNull(result);
    }

    @Test
    public void testCountNoneAnimals() {
        AnimalClinicV1 clinic = new AnimalClinicV1();

        assertEquals(0, clinic.countAnimals());
    }
    @Test
    public void testCountTenAnimals() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        clinic.addAnimal(new Animal("Jos", AnimalType.DOG, "Jaak"));
        clinic.addAnimal(new Animal("Jaak", AnimalType.DOG, "Jos"));
        clinic.addAnimal(new Animal("Frank", AnimalType.DOG, "Frankie"));
        clinic.addAnimal(new Animal("Marie", AnimalType.DOG, "Maris"));
        clinic.addAnimal(new Animal("Jacqueline", AnimalType.DOG, "Jack"));
        clinic.addAnimal(new Animal("Mariette", AnimalType.CAT, "Marianne"));
        clinic.addAnimal(new Animal("Patat", AnimalType.DOG, "Friet"));
        clinic.addAnimal(new Animal("Witte", AnimalType.CAT, "Kleurie"));
        clinic.addAnimal(new Animal("Sokje", AnimalType.CAT, "Miauw"));
        clinic.addAnimal(new Animal("Schralen bever", AnimalType.DOG, "Scheve foemp"));

        assertEquals(10, clinic.countAnimals());
    }

    @Test
    public void testFindAllAnimalsForOwner() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        Animal patat = new Animal("Patat", AnimalType.DOG, "Scheve foemp");
        Animal bever = new Animal("Schralen bever", AnimalType.DOG, "Scheve foemp");
        Animal sokje = new Animal("Sokje", AnimalType.CAT, "Miauw");
        clinic.addAnimal(patat);
        clinic.addAnimal(bever);
        clinic.addAnimal(sokje);

        assertTrue(clinic.findAllAnimalsForOwner("Scheve foemp").contains(patat));
        assertTrue(clinic.findAllAnimalsForOwner("Scheve foemp").contains(bever));
        assertTrue(clinic.findAllAnimalsForOwner("Miauw").contains(sokje));
    }
    @Test
    public void testFindAllAnimalsForUnknownOwner() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        Animal patat = new Animal("Patat", AnimalType.DOG, "Scheve foemp");
        clinic.addAnimal(patat);
        assertFalse(clinic.findAllAnimalsForOwner("U mama").contains(patat));
    }

    @Test
    public void testChangeAnimalOwner() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        Animal patat = new Animal("Patat", AnimalType.DOG, "Scheve foemp");
        clinic.addAnimal(patat);
        assertTrue(clinic.changeAnimalOwner("Patat", AnimalType.DOG, "Miauw"));
        assertSame("Miauw", clinic.findAnimal("Patat", AnimalType.DOG).getOwner());
    }
    @Test
    public void testChangeAnimalUnknownOwner() {
        AnimalClinicV1 clinic = new AnimalClinicV1();
        Animal patat = new Animal("Patat", AnimalType.DOG, "Scheve foemp");
        clinic.addAnimal(patat);
        assertTrue(clinic.changeAnimalOwner("Patat", AnimalType.DOG, "Peter"));
        assertNotSame("Miauw", clinic.findAnimal("Patat", AnimalType.DOG).getOwner());
    }
}