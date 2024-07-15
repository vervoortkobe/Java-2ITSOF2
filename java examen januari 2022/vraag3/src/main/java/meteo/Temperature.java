package meteo;

import java.time.LocalDateTime;

public class Temperature {
    private final int index;
    private final Location location;
    private final LocalDateTime time;
    private Double value;

    public Temperature(int index, Location location, LocalDateTime time, Double value) {
        this.index = index;
        this.location = location;
        this.time = time;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public Location getLocation() {
        return location;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}