package meteo;

import java.time.LocalDate;

public class Temperature implements Comparable<Temperature> {
    private final Location location;
    private final LocalDate date;
    private final double min;
    private final double avg;
    private final double max;

    public Temperature(Location location, LocalDate date, double min, double avg, double max) {
        this.location = location;
        this.date = date;
        this.min = min;
        this.avg = avg;
        this.max = max;
    }

    public Location getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }

    public double getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "location=" + location +
                ", date=" + date +
                ", min=" + min +
                ", avg=" + avg +
                ", max=" + max +
                '}';
    }

    @Override
    public int compareTo(Temperature o) {
        int verschil = o.date.compareTo(date);
        if(verschil == 0)
            return location.compareTo(o.location);
        return verschil;
    }
}
