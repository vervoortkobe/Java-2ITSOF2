package shelter;

import animals.Animal;
import animals.Cat;
import animals.Dog;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

public class AnimalShelter {
    private List<Animal> animals = new ArrayList<>();

    public void addCat(Cat cat) throws DuplicateAnimalException {
        for (Animal animal : animals) {
            if(animal instanceof Cat) {
                Cat existing = (Cat) animal;
                if(existing.equals(cat)) throw new DuplicateFormatFlagsException("a");
            }
        }
        animals.add(cat);
    }

    public void addDog(Dog dog) {
        animals.add(dog);
    }

    public void printAllAnimals() {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(i + " " + animals.get(i).toString());
        }
    }

    public void showAnimal(int index) {
        if(index < animals.size()) {
            System.out.println(animals.get(index).toString());
        }
    }

    public void removeAnimal(int index) {
        if(index < animals.size()) {
            animals.remove(index);
        }
    }
}
