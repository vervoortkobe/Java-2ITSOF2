package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LOCATIE")
public class Locatie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "naam")
    private String naam;

    @Column(name = "type")
    private String type;

    //aantal waarnemingen
    @Column(name = "waarnemingen")
    private int incidents;

    public Locatie() {
    }

    public Locatie(String naam, String type, int incidents) {
        this.naam = naam;
        this.type = type;
        this.incidents = incidents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    //type beer
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIncidents() {
        return incidents;
    }

    public void setIncidents(int incidents) {
        this.incidents = incidents;
    }
}
