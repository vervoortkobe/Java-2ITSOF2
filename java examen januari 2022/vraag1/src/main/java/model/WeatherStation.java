package model;

import jakarta.persistence.*;

@Entity
@Table(name="WEATHERSTATIONS")
public class WeatherStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    public WeatherStation() {}

    public WeatherStation(String name) {
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
