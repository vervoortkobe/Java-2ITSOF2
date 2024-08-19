package incident;

import java.time.LocalDate;
import java.util.Objects;

public class Incident {
    private final String bear;
    private final LocalDate date;
    private final AgressionType agressionType;
    private int victims;

    public Incident(String bear, LocalDate date, AgressionType agressionType, int victims) {
        this.bear = bear;
        this.date = date;
        this.agressionType = agressionType;
        this.victims = victims;
    }

    public String getBear() {
        return bear;
    }

    public LocalDate getDate() {
        return date;
    }

    public AgressionType getAgressionType() {
        return agressionType;
    }

    public int getVictims() {
        return victims;
    }

    public void setVictims(int victims) {
        this.victims = victims;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Incident)) return false;
        Incident incident = (Incident) o;
        return getVictims() == incident.getVictims() && Objects.equals(getBear(), incident.getBear()) && Objects.equals(getDate(), incident.getDate()) && getAgressionType() == incident.getAgressionType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBear(), getDate(), getAgressionType(), getVictims());
    }
}
