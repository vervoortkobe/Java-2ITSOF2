package animalClasses;

import java.time.LocalDate;

public class Dog extends Animal implements DomesticatedAnimal, FourLeggedAnimal {

    private final DogBreed breed;

    public Dog(String name, LocalDate dateOfBirth, Gender gender, DogBreed breed) {
        super(name, dateOfBirth, gender);
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed=" + breed +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                "} " + super.toString();
    }

    static final String GELUID = "WOEFWOEFWOEF";
    @Override
    public void makeSound() {
        System.out.println(GELUID);
    }
}
