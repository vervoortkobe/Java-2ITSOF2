package agenda;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws DateInPastException {
        Agenda agenda = new Agenda();
        agenda.addAppointment(new Appointment("Klant A", "vaccinatie"));
        agenda.addAppointment(new Appointment("Klant B", "controle"));
        agenda.addAppointment(new Appointment("Klant C", "operatie"));

        agenda.showNextAppointment();

        agenda.addUrgentAppointment(new Appointment("Klant U", "dringende ingreep"));

        agenda.showNextAppointment();
        agenda.showNextAppointment();
        agenda.showNextAppointment();
        agenda.showNextAppointment();

        LocalDate day1 = LocalDate.of(2023, 10, 2);
        LocalDate day2 = LocalDate.of(2023, 10, 3);
        LocalDate day3 = LocalDate.of(2023, 10, 4);
        LocalDate day4 = LocalDate.of(2023, 10, 5);
        LocalDate day5 = LocalDate.of(2023, 10, 6);

        WeekAgenda weekAgenda = new WeekAgenda();
        weekAgenda.addWorkingDay(day1);
        weekAgenda.addWorkingDay(day2);
        weekAgenda.addWorkingDay(day3);
        weekAgenda.addWorkingDay(day4);
        weekAgenda.addWorkingDay(day5);

        try {
            weekAgenda.addAppointment(day1, new Appointment("Klant A", "vaccinatie"));
            weekAgenda.addAppointment(day1, new Appointment("Klant B", "controle"));
            weekAgenda.addAppointment(day1, new Appointment("Klant C", "operatie"));
        } catch(DateInPastException e) {
            System.out.println(e.getMessage());
        }

        weekAgenda.showNextAppointment(day1);
        weekAgenda.showNextAppointment(day1);
        weekAgenda.showNextAppointment(day1);
        weekAgenda.showNextAppointment(day1);
        weekAgenda.showNextAppointment(day2);
        weekAgenda.showNextAppointment(day3);
        weekAgenda.showNextAppointment(day4);
        weekAgenda.showNextAppointment(day5);
    }
}
