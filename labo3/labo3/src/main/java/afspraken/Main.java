package afspraken;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        WeekAgenda weekAgenda = new WeekAgenda();
        weekAgenda.addWeekday(LocalDate.ofEpochDay(11-2-2023));
        weekAgenda.addWeekdayAppointment(LocalDate.ofEpochDay(11-2-2023), new Appointment("Kobe", "tanden poetsen"));
        weekAgenda.showFirstAppointment(LocalDate.ofEpochDay(11-2-2023));
    }
}
