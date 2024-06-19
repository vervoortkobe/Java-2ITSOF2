package animals;

import java.time.LocalDate;
import java.util.Objects;

public class Dog extends Animal implements DomesticatedAnimal, FourLeggedAnimal {
    private static final String SOUND = "BARKS";
    private final DogBreed breed;

    public Dog(String name, DogBreed breed, LocalDate dateOfBirth, Gender gender) {
        super(name, dateOfBirth, gender);
        this.breed = breed;
    }

    public void makeSound() {
        System.out.println(SOUND);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed=" + breed +
                ", name='" + getName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", gender=" + getGender() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return breed == dog.breed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed);
    }
}
