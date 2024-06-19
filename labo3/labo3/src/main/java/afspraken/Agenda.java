package afspraken;

import java.util.*;

public class Agenda {
    ArrayDeque<Appointment> agenda = new ArrayDeque<>();
    void makeAppointment(Appointment a) {
        agenda.addLast(a);
    }
    Appointment doAppointment() {
        if(agenda.isEmpty()) {
            System.out.println("Er zijn geen afspraken");
            return null;
        }
        Appointment firstOnTheList = agenda.peekFirst();
        agenda.poll();
        System.out.println(firstOnTheList.getCustomerName() + ": " + firstOnTheList.getReason());
        return firstOnTheList;
    }
    void makeImportantAppointment(Appointment a) {
        agenda.addFirst(a);
    }
}
