package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "FILM")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "film")
    private int film;

    @Enumerated(EnumType.STRING) // Assuming FilmType is an Enum
    @Column(name = "type")
    private FilmType type;

    @Column(name = "titel")
    private String titel;

    @Column(name = "land")
    private String land;

    @Column(name = "datum_toegevoegd")
    private LocalDate datumToegevoegd;

    @Column(name = "uitgave_jaar")
    private LocalDate uitgaveJaar;

    @Column(name = "omschrijving")
    private String omschrijving;

    @ManyToMany
    @JoinTable(
            name = "FILM_REGISSEUR",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "regisseur_id")
    )
    private Set<Regisseur> regisseurs;

    public Film() {
    }

    public Film(int film, FilmType type, String titel, String land, LocalDate datumToegevoegd, LocalDate uitgaveJaar, String omschrijving, Set<Regisseur> regisseurs) {
        this.film = film;
        this.type = type;
        this.titel = titel;
        this.land = land;
        this.datumToegevoegd = datumToegevoegd;
        this.uitgaveJaar = uitgaveJaar;
        this.omschrijving = omschrijving;
        this.regisseurs = regisseurs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FilmType getType() {
        return type;
    }

    public void setType(FilmType type) {
        this.type = type;
    }

    public int getFilm() {
        return film;
    }

    public void setFilm(int film) {
        this.film = film;
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

    public LocalDate getDatumToegevoegd() {
        return datumToegevoegd;
    }

    public void setDatumToegevoegd(LocalDate datumToegevoegd) {
        this.datumToegevoegd = datumToegevoegd;
    }

    public LocalDate getUitgaveJaar() {
        return uitgaveJaar;
    }

    public void setUitgaveJaar(LocalDate uitgaveJaar) {
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
