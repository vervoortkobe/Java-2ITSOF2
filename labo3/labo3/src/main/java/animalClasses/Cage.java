package animalClasses;

import java.util.ArrayList;
import java.util.List;

public class Cage<T extends Animal> {

    private List<T> animals;
    private int max;

    public Cage() {
        this.animals = new ArrayList<>();
    }

    public Cage(int amount) {
        this.animals = new ArrayList<>();
        this.max = amount;
    }

    public boolean addAnimal(T animal) {
        if(animals.size() == max) return false;
        animals.add(animal);
        return true;
    }

    public void showAnimals() {
        System.out.println(animals);
    }
}
