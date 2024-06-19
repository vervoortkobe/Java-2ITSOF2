package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tblAnimal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Integer id;
    @Column(name = "animal_name")
    private String name;
    @Column(name = "animal_endangered")
    private Boolean endangered;

    public Animal() {}

    public Animal(String name, Boolean endangered) {
        this.name = name;
        this.endangered = endangered;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEndangered() {
        return endangered;
    }

    public void setEndangered(Boolean endangered) {
        this.endangered = endangered;
    }
}
