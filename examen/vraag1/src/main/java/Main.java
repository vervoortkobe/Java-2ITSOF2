import dao.BeerDAO;
import dao.NatuurparkDAO;
import dao.WaarnemingDAO;
import entity.Beer;
import entity.Natuurpark;
import entity.Waarneming;
import service.DatumInToekomstException;
import service.TeLangeExtraException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws DatumInToekomstException, TeLangeExtraException {
        BeerDAO beerDAO = new BeerDAO();
        NatuurparkDAO natuurparkDAO = new NatuurparkDAO();
        WaarnemingDAO waarnemingDAO = new WaarnemingDAO();

        putBerenInDB(beerDAO);
        putNatuurparkenInDB(natuurparkDAO);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

        System.out.println("Welkom Beer");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice != 6) {
            System.out.println("Kies een optie uit de lijst:");
            System.out.println("1. Toon beren");
            System.out.println("2. Toon natuurparken");
            System.out.println("3. Voeg waarneming toe");
            System.out.println("4. Toon alle waarnemingen");
            System.out.println("5. Export waarnemingen");
            System.out.println("6. Einde");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: //toon beren
                    System.out.println("1. Dit zijn de beren:");
                    System.out.println(beerDAO.toonBeren());
                    break;
                case 2: //toon natuurparken
                    System.out.println("2. Dit zijn de natuurparken:");
                    System.out.println(natuurparkDAO.toonNatuurparken().stream()
                            .sorted((o1, o2) -> {
                                int result = o1.getProvincie().compareTo(o2.getProvincie());
                                if(result == 0) {
                                    return o1.getNaam().compareTo(o2.getNaam());
                                }
                                return result;
                            })
                            .collect(Collectors.toList()));
                    break;
                case 3: //voeg waarneming toe
                    System.out.println("3. Geef de gegevens van de waarneming in:");

                    Boolean correcteDatum = false;
                    String datum = "";
                    while(!correcteDatum) {
                        System.out.println("Datum: (d MMMM YYYY)");
                        datum = scanner.nextLine();
                        if(LocalDate.parse(datum, formatter).isAfter(LocalDate.now())) {
                            throw new DatumInToekomstException("De ingegeven datum is in de toekomst.\nGeef een correcte datum in!");
                        } else correcteDatum = true;
                    }

                    System.out.println("Natuurpark:");
                    String natuurpark= scanner.nextLine();
                    System.out.println("Beer:");
                    String beer = scanner.nextLine();

                    Boolean correcteExtra = false;
                    String extra = "";
                    while(!correcteExtra) {
                        System.out.println("Extra:");
                        extra = scanner.nextLine();
                        if(extra.length() > 50) {
                            throw new TeLangeExtraException("De ingegeven extra tekst is te lang (> 50 tekens).\nGeef een correcte extra tekst in!");
                        } else correcteExtra = true;
                    }

                    waarnemingDAO.create(
                            new Waarneming(LocalDate.parse(datum, formatter),
                            natuurparkDAO.findNatuurpark(natuurpark), //we gaan er van uit dat men een juist en bestaand natuurpark ingeeft
                            new Beer(beer),
                            extra)
                    );

                    System.out.println("Waarneming toegevoegd");
                    break;
                case 4: //toon waarnemingen
                    System.out.println("4. Dit zijn alle waarnemingen:");
                    System.out.println(waarnemingDAO.toonWaarnemingen().stream()
                            .sorted((o1, o2) -> o1.getDatum().compareTo(o2.getDatum()))
                            .map(o -> o.getDatum() + " - " + o.getNatuurpark().getProvincie() + " - " + o.getNatuurpark().getNaam() + " - " + o.getBeer().getNaam())
                            .collect(Collectors.toList())
                    );
                    break;
                case 5: //export waarnemingen
                    System.out.println("5. Exporteer waarnemingen:");
                    int animalId = scanner.nextInt();
                    scanner.nextLine();
                    //List<ConsultDTO> consults = controller.findAllConsultsForAnimal(animalId);
                    //System.out.println(consults);
                    break;
                default: //einde
                    choice = 6;
                    break;

            }
        }
    }

    private static void putBerenInDB(BeerDAO beerDAO) {
        File input = new File("src/main/resources/beren.txt");

        try {
            Files.lines(input.toPath())
                    .skip(1)
                    .filter(line -> !line.contains("Teddybeer"))
                    .map(line -> stringToBeer(line))
                    .forEach(o -> beerDAO.create(o));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Beer stringToBeer(String line) {
        return new Beer(line);
    }

    private static void putNatuurparkenInDB(NatuurparkDAO natuurparkDAO) {
        File input = new File("src/main/resources/natuurparken.csv");

        try {
            Files.lines(input.toPath())
                    .skip(1)
                    .filter(line -> !line.contains("Teddybeer"))
                    .map(line -> stringToNatuurpark(line))
                    .forEach(o -> natuurparkDAO.create(o));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Natuurpark stringToNatuurpark(String line) {
        // naam provincie
        String[] split = line.split(";");
        return new Natuurpark(split[1], split[0]);
    }
}
