package animals;

import java.time.LocalDate;

public class Hippo extends Animal {
    private static final String SOUND = "HONK";

    public Hippo(String name, Gender gender, LocalDate dateOfBirth) {
        super(name, gender, dateOfBirth);
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }
}
