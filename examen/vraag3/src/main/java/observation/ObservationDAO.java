package observation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ObservationDAO {
    private final List<Observation> db = new ArrayList<>();

    public void create(Observation observation) {
        db.add(observation);
    }

    public List<Observation> findAll() {
        return db;
    }

    public Optional<Observation> find(Bear bear, LocalDate date) {
        return db.stream()
                .filter(p -> p.getBear().getName().equals(bear.getName()) && p.getDate().equals(date))
                .findFirst();
    }

    public void delete(Observation observation) {
        db.remove(observation);
    }
}
