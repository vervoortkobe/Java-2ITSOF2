package observation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ObservationService {

    private final BearDAO bearDAO;
    private final ObservationDAO observationDAO;

    public ObservationService(BearDAO bearDAO, ObservationDAO observationDAO) {
        this.bearDAO = bearDAO;
        this.observationDAO = observationDAO;
    }

    public boolean addObservation(String bearName, LocalDate date) {
        //check bear exists
        Bear bear = bearDAO.findByName(bearName);
        if (bear == null) {
            return false;
        }
        //check date is not in future
        if (date.isAfter(LocalDate.now())) {
            return false;
        }
        //check observation does not exist
        Optional<Observation> observation = observationDAO.find(bear, date);
        if (observation.isPresent()) {
            return false;
        }
        //create new observation
        observationDAO.create(new Observation(bear, date));
        return true;
    }

    public boolean removeObservation(String bearName, LocalDate date) {
        //check bear exists
        Bear bear = bearDAO.findByName(bearName);
        if (bear == null) {
            return false;
        }
        //check observation exists
        Optional<Observation> observation = observationDAO.find(bear, date);
        if (observation.isEmpty()) {
            return false;
        }
        //delete existing observation
        observationDAO.delete(observation.get());
        return true;
    }

    public List<Observation> findAll() {
        return observationDAO.findAll();
    }

    public List<Observation> findAllForBear(String bearName) {
        //check bear exists
        Bear bear = bearDAO.findByName(bearName);
        if (bear == null) {
            return null;
        }
        //find filtered on bear name
        List<Observation> all = observationDAO.findAll();
        return all.stream().filter(p -> p.getBear().getName().equals(bearName)).collect(Collectors.toList());
    }
}
