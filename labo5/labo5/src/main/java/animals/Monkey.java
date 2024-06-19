package animals;

import java.time.LocalDate;

public class Monkey extends Animal implements WildAnimal {
    private static final String SOUND = "Chatter";

    public Monkey(String name, Gender gender, LocalDate dateOfBirth) {
        super(name, gender, dateOfBirth);
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }

    @Override
    public boolean endangered() {
        return false;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "endangered=" + endangered() +
                "} " + super.toString();
    }

}
