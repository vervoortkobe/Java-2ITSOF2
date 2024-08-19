package incident;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IncidentService {
    private final IncidentDAO dao;

    public IncidentService(IncidentDAO dao) {
        this.dao = dao;
    }

    public Incident addIncident(String bear, LocalDate date, AgressionType type, int victims) {
        //check required
        if (bear == null || date == null || type == null) {
            return null;
        }
        //check date is not in future
        if (date.isAfter(LocalDate.now())) {
            return null;
        }
        //check already exists
        Optional<Incident> incident = dao.find(bear, date, type);
        if (incident.isPresent()) {
            //update the victims of the incident
            incident.get().setVictims(victims);
            return incident.get();
        } else {
            //create new incident
            return dao.create(new Incident(bear, date, type, victims));
        }
    }

    public boolean removeIncident(String bear, LocalDate date, AgressionType type) {
        //check exists
        Optional<Incident> incident = dao.find(bear, date, type);
        if (incident.isEmpty()) {
            return false;
        }
        //delete existing position
        dao.delete(incident.get());
        return true;
    }

    public List<Incident> findAllIncidentsForBear(String bear) {
        List<Incident> all = dao.getAll();
        return all.stream().filter(p -> p.getBear().equals(bear)).collect(Collectors.toList());
    }
}
