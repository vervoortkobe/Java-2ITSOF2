package entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tblFilm")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer id;
    @Column(name = "filmid")
    private Integer filmId;
    @Column(name = "film_type")
    private FilmType filmType;
    @Column(name = "film_titel")
    private String titel;
    @Column(name = "film_land")
    private String land;
    @Column(name = "film_datum")
    private LocalDate datum;
    @Column(name = "film_uitgavejaar")
    private LocalDate uitgaveJaar;
    @Column(name = "film_omschrijving")
    private String omschrijving;
    @ManyToMany
    @Column(name = "film_regisseurs")
    private Set<Regisseur> regisseurs;

    public Film() {}

    public Film(int filmId, FilmType filmType, String titel, String land, LocalDate datum, LocalDate uitgaveJaar, String omschrijving, Set<Regisseur> regisseurs) {
        this.filmId = filmId;
        this.filmType = filmType;
        this.titel = titel;
        this.land = land;
        this.datum = datum;
        this.uitgaveJaar = uitgaveJaar;
        this.omschrijving = omschrijving;
        this.regisseurs = regisseurs;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public FilmType getFilmType() {
        return filmType;
    }

    public void setFilmType(FilmType filmType) {
        this.filmType = filmType;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalDate getUitgaveJaar() {
        return uitgaveJaar;
    }

    public void setUitgaveJaar(LocalDate uitgifteJaar) {
        this.uitgaveJaar = uitgaveJaar;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Set<Regisseur> getRegisseurs() {
        return regisseurs;
    }

    public void setRegisseurs(Set<Regisseur> regisseurs) {
        this.regisseurs = regisseurs;
    }
}
