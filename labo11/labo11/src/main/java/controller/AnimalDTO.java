package controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnimalDTO {
    @JsonProperty("id")
    private int id;
    private String name;
    private Boolean endangered;
}
