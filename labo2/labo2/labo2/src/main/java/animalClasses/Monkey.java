package animalClasses;

import java.time.LocalDate;

public class Monkey extends Animal implements WildAnimal, FourLeggedAnimal {
    public Monkey(String name, LocalDate dateOfBirth, Gender gender) {
        super(name, dateOfBirth, gender);
    }

    @Override
    public String toString() {
        return "Monkey{" +
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
