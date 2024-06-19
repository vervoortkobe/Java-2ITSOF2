package animalClasses;

import java.time.LocalDate;

public class Lion extends Animal implements WildAnimal, FourLeggedAnimal {
    public Lion(String name, LocalDate dateOfBirth, Gender gender) {
        super(name, dateOfBirth, gender);
    }

    @Override
    public String toString() {
        return "Lion{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", is endangered=" + WildAnimal.isEndangered() +
                "} " + super.toString();
    }

    @Override
    void makeSound() {

    }
}