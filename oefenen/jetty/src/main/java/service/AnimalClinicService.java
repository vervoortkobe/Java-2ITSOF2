package service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dao.AnimalDAO;
import dao.ConsultDAO;
import entity.Animal;
import entity.AnimalType;
import entity.Consult;

public class AnimalClinicService {
    private final ConsultDAO consultDAO;
    private final AnimalDAO animalDAO;

    public AnimalClinicService(ConsultDAO consultDAO, AnimalDAO animalDAO) {
        this.consultDAO = consultDAO;
        this.animalDAO = animalDAO;
    }

    /**
     * Adds an unique Animal to the clinic.
     *
     * @param name  String
     * @param type  AnimalType
     * @param owner String
     * @return true if successful, false if failed
     */
    public boolean addAnimal(String name, AnimalType type, String owner) {
        if (!this.animalDAO.existAnimal(name, type, owner)) {
            Animal animal = new Animal(name, type, owner);
            this.animalDAO.create(animal);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finds all animals for an owner
     *
     * @param owner name of the owner
     * @return list of Animals for the owner
     */
    public List<Animal> findAllAnimalsForOwner(String owner) {
        return this.animalDAO.findAll().stream().filter(p -> p.getOwner().equals(owner)).collect(Collectors.toList());
    }

    /**
     * Finds an Animal in the clinic
     *
     * @param id id of the animal
     * @return the animal if found or NULL if not found
     */
    public Animal findAnimal(int id) {
        return this.animalDAO.findById(id).orElse(null);
    }

    /**
     * Adds a consult to the clinic.
     *
     * @param animalId Animal : required
     * @param date
     * @param reason
     * @return true if successful, false if failed
     */
    public boolean addConsult(int animalId, LocalDate date, String reason) {
        Optional<Animal> animal = this.animalDAO.findById(animalId);
        if (animal.isPresent()) {
            Consult consult = new Consult(animal.get(), date, reason);
            this.consultDAO.create(consult);
            return true;
        } else {
            return false;
        }
    }


    /**
     * Finds all consults for an animal.
     *
     * @param animalId the id of the animal
     * @return list of Consult objects if animal is found, or empty list if animal is not found
     */
    public List<Consult> findAllConsultsForAnimal(int animalId) {
        Optional<Animal> animal = this.animalDAO.findById(animalId);
        if (animal.isPresent()) {
            return this.consultDAO.findAll().stream().filter(p -> p.getAnimal().equals(animal.get())).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }
}
