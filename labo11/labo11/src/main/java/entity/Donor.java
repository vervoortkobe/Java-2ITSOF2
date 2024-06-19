package entity;

import jakarta.persistence.*;

import java.awt.*;

@Entity
@Table(name = "tblDonor")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id")
    private Integer id;
    @Column(name = "donor_name")
    private String name;
    @Column(name = "donor_company")
    private String company;

    public Donor() {}

    public Donor(String name, String company) {
        this.name = name;
        this.company = company;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
