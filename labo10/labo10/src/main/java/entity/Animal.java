package entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AnimalType type;
    @Column(name = "owner")
    private String owner;

    public Animal() {
    }

    public Animal(String name, AnimalType type, String owner) {
        this.name = name;
        this.type = type;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getId() == animal.getId() && Objects.equals(getName(), animal.getName()) && getType() == animal.getType() && Objects.equals(getOwner(), animal.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getType(), getOwner());
    }
}
