package animalShelter;

import animalClasses.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    List<Animal> animals = new ArrayList<>();

    void addCat(Cat cat) {
        animals.add(cat);
    }
    void addDog(Dog dog) {
        animals.add(dog);
    }
    void printAllAnimals() {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(i + ". " + animals.get(i));
        }
    }
    void showAnimal(int i) {
        System.out.println(animals.get(i).toString());
    }
    void removeAnimal(int i) {
        animals.remove(i);
    }
}
