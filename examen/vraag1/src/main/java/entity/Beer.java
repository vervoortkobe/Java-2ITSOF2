package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "beer")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beer_id")
    private int id;

    @Column(name = "beer_naam")
    private String naam;

    public Beer() {}

    public Beer(String naam) {
        this.naam = naam;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
