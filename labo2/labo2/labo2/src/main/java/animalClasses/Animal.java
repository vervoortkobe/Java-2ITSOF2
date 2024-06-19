package animalClasses;

import java.time.LocalDate;
import java.time.Period;

public abstract class Animal {

    protected final String name;
    //protected int age;
    protected LocalDate dateOfBirth;
    protected Gender gender;

    public String getName() {
        return name;
    }
    //public int getAge() { return age; }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public Gender getGender() {
        return gender;
    }
    public String getAge() {
        Period period = Period.between(dateOfBirth, LocalDate.now());
        int x = period.getYears();
        int y = period.getMonths();
        int z = period.getDays();
        return "De leeftijd is " + x + " jaar, " + y + " maand en " + z + " dag.";
    }

    public Animal(String name, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        //this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    abstract void makeSound();
}
