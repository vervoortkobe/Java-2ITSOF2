package ziekenfiches;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tblCard")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer id;
    @Column(name = "card_date")
    private LocalDate date;
    @Column(name = "card_reason")
    private String reason;
    @Column(name = "card_treatment")
    private String treatment;

    public Card() {
    }

    public Card(LocalDate date, String reason, String treatment) {
        this.date = date;
        this.reason = reason;
        this.treatment = treatment;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}