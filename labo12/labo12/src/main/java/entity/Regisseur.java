package entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tblRegisseur")
public class Regisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regisseur_id")
    private Integer id;
    @Column(name = "regisseur_naam")
    private String naam;
    @ManyToOne
    @Column(name = "regisseur_films")
    private Film film;

    public Regisseur() { }

    public Regisseur(String naam, Film films) {
        this.naam = naam;
        this.film = films;
    }

    public Integer getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
