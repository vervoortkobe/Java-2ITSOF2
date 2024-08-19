package entity;

import java.time.LocalDate;

public class Beer {

    private String type;

    public Beer() {
    }

    public Beer(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
