package bear;

import java.time.LocalDate;
import java.util.Comparator;

public class BearSpotting {
    private final LocalDate date;
    private final BearType type;
    private final Location location;
    private final int accuracy;

    public BearSpotting(LocalDate date, BearType type, Location location, int accuracy) {
        this.date = date;
        this.type = type;
        this.location = location;
        this.accuracy = accuracy;
    }

    public LocalDate getDate() {
        return date;
    }

    public BearType getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public int getAccuracy() {
        return accuracy;
    }

    @Override
    public String toString() {
        return "BearSpotting{" +
                "date=" + date +
                ", type=" + type +
                ", location=" + location +
                ", accuracy=" + accuracy +
                '}';
    }

    /*@Override
    public int compareTo(BearSpotting o1, BearSpotting o2) {
        //-X, 0, +X
        int result = o1.getDate().compareTo(o2.getDate());
        if(result == 0) {
            return o1.getType().compareTo(o2.getType());
        }
        return result;
    }*/
}
