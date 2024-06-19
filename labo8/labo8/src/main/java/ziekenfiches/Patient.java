package ziekenfiches;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblPatient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer id;
    @Column(name = "patient_name")
    private String name;
    @Column(name = "patient_type")
    private Type type;
    @OneToMany(mappedBy = "tblPatient")
    @Column(name = "patient_cards")
    private List<Card> cardList;

    public Patient() {
    }

    public Patient(String name, Type type, List<Card> cardList) {
        this.name = name;
        this.type = type;
        this.cardList = cardList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
