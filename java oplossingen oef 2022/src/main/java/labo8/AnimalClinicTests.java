package labo8;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class AnimalClinicTests {
    @Test
    void addOneAnimal() {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(mock(Animal.class));
        assertEquals(1, clinic.countAnimals());
    }

    @Test
    void addTwoDifferentAnimals()
    {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(mock(Animal.class));
        clinic.addAnimal(mock(Animal.class));
        assertEquals(2,clinic.countAnimals());
    }

    @Test
    void addTwoOfTheSameAnimals()
    {
        AnimalClinic clinic = new AnimalClinic();
        Animal mockedAnimal = mock(Animal.class);

        clinic.addAnimal(mockedAnimal);
        clinic.addAnimal(mockedAnimal);
        assertEquals(1,clinic.countAnimals());
    }

    @Test
    void findAnimalFromClinicWithOneAnimal()
    {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(new Animal("Dog", AnimalType.DOG, "Souleymane"));

        Animal result = clinic.findAnimal("Dog", AnimalType.DOG);

        assertEquals( "Souleymane",result.getOwner());
    }

    @Test
    void findAnimalFromClinicWithTwoDifferentAnimals()
    {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(new Animal("Dog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Cat", AnimalType.CAT, "Souleymane"));

        Animal result = clinic.findAnimal("Cat", AnimalType.CAT);
        assertEquals("Cat",result.getName());
    }
    @Test
    void findAnimalFromClinicWithTwoOfTheSameAnimals()
    {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(new Animal("Dog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dog", AnimalType.DOG, "Souleymane"));

        assertNull(clinic.findAnimal("sdf", AnimalType.DOG));
    }

    @Test
    void countAnimalsIfZero()
    {
        AnimalClinic clinic = new AnimalClinic();

        assertEquals(clinic.countAnimals(), 0);
    }

    @Test
    void countAnimalsOfClinicWithTenAnimals()
    {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(new Animal("Dodfg", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("fdDog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dsdqog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dosfdgsfds", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dosfsg", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dfdsog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dfsdog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dodfsg", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Ddsqog", AnimalType.DOG, "Souleymane"));

        assertEquals(clinic.countAnimals(), 10);

    }

    @Test
    void findAllAnimalsForOwner()
    {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(new Animal("Dog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("fdDog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dsdqog", AnimalType.DOG, "Souleymane"));

        assertTrue(clinic.findAllAnimalsForOwner("Souleymane").stream().map(Animal::getName).collect(Collectors.toList()).contains("Dog"));
    }

    @Test
    void findAllAnimalsForUnknownOwner()
    {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(new Animal("Dog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("fdDog", AnimalType.DOG, "Souleymane"));
        clinic.addAnimal(new Animal("Dsdqog", AnimalType.DOG, "Souleymane"));

        assertEquals(0, clinic.findAllAnimalsForOwner("sd").size());
    }

    @Test
    void changeExistingAnimalOwner()
    {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(new Animal("Dog", AnimalType.DOG, "Souleymane"));


        assertTrue(clinic.changeAnimalOwner("Dog", AnimalType.DOG, "Saadi"));
        assertEquals("Saadi", clinic.findAnimal("Dog", AnimalType.DOG).getOwner());
    }

    @Test
    void changeUnexistingAnimalOwner()
    {
        AnimalClinic clinic = new AnimalClinic();
        clinic.addAnimal(new Animal("Dog", AnimalType.DOG, "Souleymane"));

        assertFalse(clinic.changeAnimalOwner("sdf", AnimalType.DOG, "Saadi"));
    }
}
