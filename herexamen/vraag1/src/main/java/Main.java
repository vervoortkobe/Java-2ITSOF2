
import com.sun.jdi.InconsistentDebugInfoException;
import dao.IncidentDAO;
import dao.LocatieDAO;
import entity.Incident;
import entity.Locatie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PutIncidentsInDb();
        IncidentDAO incidentDAO = new IncidentDAO();
        //System.out.println(incidentDao.findAll());
        LocatieDAO locatieDAO = new LocatieDAO();

        System.out.println("Welkom bij organisatie 'Welkom Beer!'");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("Maak je keuze uit volgende opties");
            System.out.println("1 : toon locaties");
            System.out.println("2 : voeg incident toe");
            System.out.println("3 : toon alle incidenten");
            System.out.println("4 : export incidenten");
            System.out.println("5 : einde");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Dit zijn alle locaties:");
                    for (Locatie locatie : locatieDAO.sortByNameAndTypeBear()) {
                        System.out.println(locatie);
                    }
                    break;
                case 2:
                    System.out.println("Voer de gegevens van het incident in:");
                    //addDog(controller, scanner);
                    break;
                case 3:
                    System.out.println("Dit zijn alle incidenten:");
                    //formatIncidents();
                    break;
                case 4:
                    System.out.println("Export incidenten:");
                    getFilterOptie();
                    break;
                default:
                    choice = 5;
                    break;
            }
        }
    }

    private static void getFilterOptie() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice == 0) {
            System.out.println("Maak je keuze uit volgende opties");
            System.out.println("1 : geen filtering");
            System.out.println("2 : enkel agressie");
            System.out.println("3 : enkel verwonding");
            System.out.println("4 : enkel doodslag");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Geen filtering:");

                    break;
                case 2:
                    System.out.println("Enkel agressie:");

                    break;
                case 3:
                    System.out.println("Enkel verwonding:");

                    break;
                case 4:
                    System.out.println("Enkel doodslag:");

                    break;
                default:
                    choice = 0;
                    break;
            }
        }
    }

    private static void PutIncidentsInDb() {
        IncidentDAO dao = new IncidentDAO();
        File input = new File("src/main/resources/waarnemingen.csv");
        try {
            Files.lines(input.toPath())
                    .skip(1)
                    .forEach(l -> dao.createNew(stringToIncident(l)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //datumtijd locatie type slachtoffer
    //datum;park;zone;type
    private static Incident stringToIncident(String line) {
        String[] split = line.split(";");

        //split[0]
        int year = Integer.parseInt(split[0].split("/")[0]);
        int month = Integer.parseInt(split[0].split("/")[1].split("/")[0]);
        int dayOfMonth = Integer.parseInt(split[0].split("/")[1].split("/")[1]);
        LocalDate datumtijd = LocalDate.of(year, month, dayOfMonth);

        //naam type aantal_inci
        String park = split[1].split(";")[0];
        String zone = split[1].split(";")[1].split(";")[0];
        String locatieNaam = park + " - " + zone;
        String locatieBeerType = split[1].split(";")[1].split(";")[1];
        int locatieAantalInci = getAmountOfIncidents(park, zone, locatieBeerType);
        Locatie locatie = new Locatie(locatieNaam, locatieBeerType, locatieAantalInci);


        return new Incident(
                datumtijd,
                locatie,
                null,
                null
        );
    }

    private static int getAmountOfIncidents(String park, String zone, String typeBeer) {
        File input = new File("src/main/resources/waarnemingen.csv");

        int amount = 0;

        try {
            amount = (int) Files.lines(input.toPath())
                    .skip(1)
                    .filter(l -> l.contains(park) && l.contains(zone) && l.contains(typeBeer))
                    .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return amount;
    }

    private static void exportIncidents() {
    }

    private static void WriteToCsv() {
        System.out.println("Saving incidents ...");
        IncidentDAO incidentDAO = new IncidentDAO();
        File csvOutputFile = new File("src/main/resources/export.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            incidentDAO.findAll().stream().forEach(c -> {
                System.out.println(c);
                pw.print(String.format("%2$s %1$s € %3$.2f %1$s %4$s", ';',c.getDatumtijd(),c.getLocatie(),c.getType(), c.getSlachtoffer()));
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Orders Saved!");

    }

    private static void formatIncidents() {
        IncidentDAO incidentDAO = new IncidentDAO();
        incidentDAO.findAll().forEach(i -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy", Locale.ENGLISH);
            LocalDate date = LocalDate.parse(i.getDatumtijd().toString(), formatter);

            //System.out.println(date + " / " + i.getLocatie().getNaam()) + " / " + i.getType() + " / " + i.getLocatie().getType() + " / " + i.getLocatie().getIncidents().toString();
        });
    }
}
