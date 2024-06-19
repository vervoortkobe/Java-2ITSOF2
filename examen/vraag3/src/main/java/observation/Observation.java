package observation;

import java.time.LocalDate;

public class Observation {
    private final Bear bear;
    private final LocalDate date;

    public Observation(Bear bear, LocalDate date) {
        this.bear = bear;
        this.date = date;
    }

    public Bear getBear() {
        return bear;
    }

    public LocalDate getDate() {
        return date;
    }
}
