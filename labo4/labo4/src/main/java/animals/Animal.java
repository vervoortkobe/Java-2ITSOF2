package animals;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Animal implements Comparable<Animal> {
    private final String name;
    private final LocalDate dateOfBirth;
    private final Gender gender;

    public Animal(String name, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAge() {
        Period period = Period.between(dateOfBirth, LocalDate.now());
        return "De leeftijd is " + period.getYears() + " jaar, " + period.getMonths() + " maand en " + period.getDays() + " dag";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(getName(), animal.getName()) && Objects.equals(getDateOfBirth(), animal.getDateOfBirth()) && getGender() == animal.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDateOfBirth(), getGender());
    }

    @Override
    public int compareTo(Animal o) {
        return name.compareTo(o.name);
    }
}
