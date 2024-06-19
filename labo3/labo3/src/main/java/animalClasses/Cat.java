package animalClasses;

import java.time.LocalDate;

public class Cat extends Animal implements DomesticatedAnimal, FourLeggedAnimal {

    private final CatBreed breed;

    public Cat(String name, LocalDate dateOfBirth, Gender gender, CatBreed breed) {
        super(name, dateOfBirth, gender);
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed=" + breed +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                "} " + super.toString();
    }

    static final String GELUID = "MIAAAAUWWW";
    @Override
    public void makeSound() {
        System.out.println(GELUID);
    }
}
