package animals;

import java.time.LocalDate;

public class Lion extends Animal implements WildAnimal, FourLeggedAnimal {
    private static final String SOUND = "Roar";

    public Lion(String name, Gender gender, LocalDate dateOfBirth) {
        super(name, gender, dateOfBirth);
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }

    @Override
    public boolean endangered() {
        return true;
    }

    @Override
    public String toString() {
        return "Lion{" +
                "endangered=" + endangered() +
                "} " + super.toString();
    }
}
