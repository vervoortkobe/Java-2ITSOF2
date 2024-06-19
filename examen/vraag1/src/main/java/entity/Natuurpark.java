package entity;


import jakarta.persistence.*;

@Entity
@Table(name = "natuurpark")
public class Natuurpark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "natuurpark_id")
    private int id;
    @Column(name = "natuurpark_naam")
    private String naam;
    @Column(name = "natuurpark_provincie")
    private String provincie;

    public Natuurpark() {}

    public Natuurpark(String naam, String provincie) {
        this.naam = naam;
        this.provincie = provincie;
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

    public String getProvincie() {
        return provincie;
    }

    public void setProvincie(String provincie) {
        this.provincie = provincie;
    }
}
