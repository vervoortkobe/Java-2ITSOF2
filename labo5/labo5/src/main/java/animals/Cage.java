package animals;

import java.util.ArrayList;
import java.util.List;

public class Cage<T extends Animal> {
    private final List<T> animals;
    private final int max;

    public Cage(int max) {
        this.animals = new ArrayList<>();
        this.max = max;
    }

    public void addAnimal(T animal) {
        if(this.animals.size() < max) {
            animals.add(animal);
        } else {
            System.out.println("De kooi zit vol");
        }
    }

    public void showAnimals() {
        System.out.println(animals);
    }
}
