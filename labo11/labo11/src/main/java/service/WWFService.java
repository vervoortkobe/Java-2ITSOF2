package service;

import entity.Animal;
import entity.Donor;
import dao.AnimalDAO;
import java.util.List;

import java.time.LocalDate;

public class WWFService {
    private AnimalDAO animalDAO;

    public void addDonation(String animalName, String donorName, LocalDate date, Integer amount)
        Animal animal = this.animalDAO.findAll().stream().filter(p -> p.getName().equals(animalName));
        Donor donor = this.donorDAO.findAll().stream().filter(p -> p.getName().equals(donorName)).find();
        if(animal == null) throw new DonationException("animal");
        if(donor == null) throw new DonationException("donor");
        if(amount < 0) throw new DonationException("amount");
        this.donationDAO.create(new Donation(animal, donor, date, amount));

        public List<Animal> findAllAnimals() { return this.animalDAO.findAll(); }
}
