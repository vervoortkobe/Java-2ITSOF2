package incident;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IncidentDAO {
    private final List<Incident> db = new ArrayList<>();

    public List<Incident> getAll() {
        return db;
    }

    public Optional<Incident> find(String bear, LocalDate date, AgressionType type) {
        return db.stream()
                .filter(p -> p.getBear().equals(bear) && p.getDate().equals(date) && p.getAgressionType() == type)
                .findFirst();
    }

    public Incident create(Incident incident) {
        db.add(incident);
        return incident;
    }

    public void delete(Incident incident) {
        db.remove(incident);
    }
}
