package clinic;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dao.AnimalDAO;
import model.Animal;
import model.AnimalType;

public class AnimalClinicV2 {
    private final AnimalDAO dao;

    public AnimalClinicV2(AnimalDAO dao) {
        this.dao = dao;
    }

    /**
     * Adds an unique Animal to the clinic.
     *
     * @param animal
     * @return the number of animals in the clinic
     */
    public int addAnimal(Animal animal) {
        if(!this.dao.existAnimal(animal)) {
            this.dao.createAnimal(animal);
        }
        return this.dao.findAll().size();
    }

    /**
     * Change the owner of an Animal in the clinic
     *
     * @param name     name of the animal
     * @param type     type of the animal : CAT or DOG
     * @param newOwner name of the new owner
     * @return true animal found and owner changed, false animal not found
     */
    public boolean changeAnimalOwner(String name, AnimalType type, String newOwner) {
        Optional<Animal> animal = this.dao.findAll().stream().filter(p -> p.getName().equals(name) && p.getType().equals(type)).findFirst();
        animal.ifPresent(p -> p.changeOwner(newOwner));
        return animal.isPresent();
    }

    /**
     * Finds an Animal in the clinic
     *
     * @param name name of the animal
     * @param type type of the animal : CAT or DOG
     * @return the animal if found or NULL if not found
     */
    public Animal findAnimal(String name, AnimalType type) {
        return this.dao.findAll().stream().filter(p -> p.getName().equals(name) && p.getType().equals(type)).findFirst().orElse(null);
    }

    /**
     * Counts the number of Animals in the clinic
     *
     * @return the number of animals in the clinic
     */
    public int countAnimals() {
        return this.dao.findAll().size();
    }

    /**
     * Finds all animals for an owner
     *
     * @param owner name of the owner
     * @return list of Animals for the owner
     */
    public List<Animal> findAllAnimalsForOwner(String owner) {
        return this.dao.findAll().stream().filter(p -> p.getOwner().equals(owner)).collect(Collectors.toList());
    }
}
