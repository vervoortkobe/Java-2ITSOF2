package animals;

import java.time.LocalDate;

public class Dog extends Animal implements DomesticatedAnimal, FourLeggedAnimal {
    private static final String SOUND = "Barks";

    private final DogBreed breed;

    public Dog(String name, DogBreed breed, Gender gender, LocalDate dateOfBirth) {
        super(name, gender, dateOfBirth);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed=" + breed +
                "} " + super.toString();
    }
}
