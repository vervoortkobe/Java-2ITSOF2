package agenda;

import javax.swing.text.html.Option;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class Agenda {
    private final Deque<Appointment> appointments = new ArrayDeque<>();

    public void addAppointment(Appointment appointment) {
        appointments.offerLast(appointment);
    }

    public void addUrgentAppointment(Appointment appointment) {
        appointments.offerFirst(appointment);
    }

    public void showNextAppointment() {
        Appointment appointment = appointments.poll();
        if(appointment == null) {
            System.out.println("Er zijn geen afspraken");
        } else {
            System.out.println(appointment);
        }
    }

    public Optional<Appointment> getNextAppointment() {
        Appointment appointment = appointments.poll();
        //if(appointment == null) return Optional.empty();
        //else return Optional.of(appointment);
        return Optional.ofNullable(appointment);
        //return appointments.poll() == null ? Optional.empty() : Optional.of(appointment);
    }
}
