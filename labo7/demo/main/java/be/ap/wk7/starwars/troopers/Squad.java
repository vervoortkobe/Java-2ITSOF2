package be.ap.wk7.starwars.troopers;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tblSquad")
public class Squad {

    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="tbl_squad_trooper")
    private Set<StormTrooper> troopers;

    public Squad() {

    }

    public Squad(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
