package controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ConsultDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("animal_id")
    private int animalId;
    @JsonProperty("date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    @JsonProperty("reason")
    private String reason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ConsultDTO{" +
                "id=" + id +
                ", animalId=" + animalId +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                '}';
    }
}
