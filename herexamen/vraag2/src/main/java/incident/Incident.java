package incident;

import java.time.Month;
import java.util.Comparator;

public class Incident implements Comparable<Incident> {
    private final Month month;
    private final Location location;
    private final BearType bearType;
    private final AgressionType agressionType;
    private final int victims;

    public Incident(Month month, Location location, BearType bearType, AgressionType agressionType, int victims) {
        this.month = month;
        this.location = location;
        this.bearType = bearType;
        this.agressionType = agressionType;
        this.victims = victims;
    }

    public Month getMonth() {
        return month;
    }

    public Location getLocation() {
        return location;
    }

    public BearType getBearType() {
        return bearType;
    }

    public AgressionType getAgressionType() {
        return agressionType;
    }

    public int getVictims() {
        return victims;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "month=" + getMonth() +
                ", location=" + getLocation() +
                ", bearType=" + getBearType() +
                ", agressionType=" + getAgressionType() +
                ", victims=" + getVictims() +
                '}';
    }



    //standaard sorteert op slachtoffers (victims) aflopend en beertype (bearType) alfabetisch.

    @Override
    public int compareTo(Incident o) {
        //-X, 0, +X
        int result = o.victims - victims;
        if(result == 0) {
            return bearType.compareTo(o.getBearType());
        }
        return result;
    }
}
