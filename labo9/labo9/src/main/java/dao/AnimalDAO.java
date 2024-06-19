package dao;

import java.util.ArrayList;
import java.util.List;

import model.Animal;

/**
 * Deze AnimalDAO class heeft geen echte database achter zich steken.
 * We doen even alsof we een database gebruiken.
 */
public class AnimalDAO {
    private final List<Animal> animals;

    public AnimalDAO() {
        animals = new ArrayList<>();
    }

    public void createAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public List<Animal> findAll() {
        return this.animals;
    }

    public boolean existAnimal(Animal animal) {
        return this.animals.contains(animal);
    }
}
