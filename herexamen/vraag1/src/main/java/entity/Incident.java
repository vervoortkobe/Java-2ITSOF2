package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Table(name = "INCIDENT")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "datumtijd")
    private LocalDate datumtijd;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locatie_id")
    private Locatie locatie;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private IncidentType type;

    //naam slachtoffer
    @Column(name = "slachtoffer")
    private String slachtoffer;

    public Incident() {
    }

    public Incident(LocalDate datumtijd, Locatie locatie, IncidentType type, String slachtoffer) {
        this.datumtijd = datumtijd;
        this.locatie = locatie;
        this.type = type;
        this.slachtoffer = slachtoffer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDatumtijd() {
        return datumtijd;
    }

    public void setDatumtijd(LocalDate datumtijd) {
        this.datumtijd = datumtijd;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    public IncidentType getType() {
        return type;
    }

    public void setType(IncidentType type) {
        this.type = type;
    }

    public String getSlachtoffer() {
        return slachtoffer;
    }

    public void setSlachtoffer(String slachtoffer) {
        this.slachtoffer = slachtoffer;
    }
}
