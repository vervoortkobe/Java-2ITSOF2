package afspraken;

import java.time.LocalDate;
import java.util.HashMap;

public class WeekAgenda {
    HashMap<LocalDate, Agenda> weekAgenda = new HashMap<>();
    void addWeekday(LocalDate date) {
        weekAgenda.put(date, new Agenda());
    }
    void addWeekdayAppointment(LocalDate date, Appointment a) {
        weekAgenda.get(date).agenda.addLast(a);
    }
    Appointment showFirstAppointment(LocalDate date) {
        return weekAgenda.get(date).agenda.peek();
    }
}
