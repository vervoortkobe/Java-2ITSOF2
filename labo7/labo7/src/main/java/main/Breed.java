package main;

import jakarta.persistence.*;

@Entity
@Table(name = "tblBreed")
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kolom_id")
    private Integer id;
    @Column(name = "name")
    private String breed;
    @Column(name = "weight_male")
    private Double weightMale;
    @Column(name = "weight_female")
    private Double weightFemale;
    @Column(name = "average_age")
    private String averageAge;

    public Breed() {
    }

    public Breed(String breed, Double weightMale, Double weightFemale, String averageAge) {
        this.breed = breed;
        this.weightMale = weightMale;
        this.weightFemale = weightFemale;
        this.averageAge = averageAge;
    }

    public Integer getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public Double getWeightMale() {
        return weightMale;
    }

    public Double getWeightFemale() {
        return weightFemale;
    }

    public String getAverageAge() {
        return averageAge;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setWeightMale(Double weightMale) {
        this.weightMale = weightMale;
    }

    public void setWeightFemale(Double weightFemale) {
        this.weightFemale = weightFemale;
    }

    public void setAverageAge(String averageAge) {
        this.averageAge = averageAge;
    }
}
