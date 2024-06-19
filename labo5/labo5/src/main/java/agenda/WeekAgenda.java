package agenda;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WeekAgenda {
    private final Map<LocalDate, Agenda> agendas = new HashMap<>();

    public void addWorkingDay(LocalDate date) {
        agendas.put(date, new Agenda());
    }

    public void addAppointment(LocalDate date, Appointment appointment) throws DateInPastException {
        if(date.isBefore(LocalDate.now())) {
            throw new DateInPastException("De datum " + date + " ligt in het verleden.");
        }
        agendas.get(date).addAppointment(appointment);
    }

    public void showNextAppointment(LocalDate date) {
        agendas.get(date).showNextAppointment();
    }

    public Optional<Appointment> getNextAppointment() { return Optional.empty();}
}
