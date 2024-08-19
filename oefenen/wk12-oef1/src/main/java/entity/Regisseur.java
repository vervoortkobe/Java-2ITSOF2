package entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "REGISSEUR")
public class Regisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "naam")
    private String naam;

    @ManyToMany(mappedBy = "regisseurs")
    private Set<Film> films;

    public Regisseur() {
    }

    public Regisseur(String naam, Set<Film> films) {
        this.naam = naam;
        this.films = films;
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

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilm(Set<Film> films) {
        this.films = films;
    }
}
