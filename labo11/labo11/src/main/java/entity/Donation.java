package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tblDonation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_id")
    private Integer id;
    @OneToOne
    @Column(name = "donation_donor")
    private Donor donor;
    @OneToOne
    @Column(name = "donation_animal")
    private Animal animal;
    @Column(name = "donation_amount")
    private int amount;
    @Column(name = "donation_date")
    private LocalDate date;

    public Donation() {}

    public Donation(Donor donor, Animal animal, int amount, LocalDate date) {
        this.donor = donor;
        this.animal = animal;
        this.amount = amount;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
