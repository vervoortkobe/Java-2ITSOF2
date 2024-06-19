package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "waarneming")
public class Waarneming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waarneming_id")
    private int id;

    @Column(name = "waarneming_datum")
    private LocalDate datum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "natuurpark_id")
    private Natuurpark natuurpark;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "beer_id")
    private Beer beer;

    @Column(name = "waarneming_extra")
    private String extra;

    public Waarneming() {}

    public Waarneming(LocalDate datum, Natuurpark natuurpark, Beer beer, String extra) {
        this.datum = datum;
        this.natuurpark = natuurpark;
        this.beer = beer;
        this.extra = extra;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Natuurpark getNatuurpark() {
        return natuurpark;
    }

    public void setNatuurpark(Natuurpark natuurpark) {
        this.natuurpark = natuurpark;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
