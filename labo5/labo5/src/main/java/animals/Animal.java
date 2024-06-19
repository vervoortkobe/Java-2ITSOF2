package animals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Animal {
    private final String name;
    private Gender gender;
    private final LocalDate dateOfBirth;

    public Animal(String name, Gender gender, LocalDate dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAge() {
        //optie 1 - Duration
        Duration duration = Duration.between(dateOfBirth, LocalDate.now());
        long totalDays = duration.toDays();
        long years = totalDays / 365;
        long remainder = totalDays % 365;
        long months = remainder / 30;
        long days = remainder % 30;

        //optie 2 - Period
        Period period = Period.between(dateOfBirth, LocalDate.now());
        years = period.getYears();
        months = period.getMonths();
        days = period.getDays();

        return "De leeftijd is " + years + " jaar, " + months + " maand en " + days + " dag.";
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && gender == animal.gender && Objects.equals(dateOfBirth, animal.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, dateOfBirth);
    }
}
