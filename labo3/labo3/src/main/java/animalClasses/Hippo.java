package animalClasses;

import java.time.LocalDate;

public class Hippo extends Animal implements WildAnimal, FourLeggedAnimal {

    public Hippo(String name, LocalDate dateOfBirth, Gender gender) {
        super(name, dateOfBirth, gender);
    }

    @Override
    public String toString() {
        return "Hippo{" +
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
