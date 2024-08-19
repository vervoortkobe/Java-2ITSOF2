import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import controller.AnimalClinicController;
import controller.AnimalDTO;
import controller.ConsultDTO;
import dao.AnimalDAO;
import dao.ConsultDAO;
import service.AnimalClinicService;

public class Main {

    public static void main(String[] args) {

        AnimalDAO animalDAO = new AnimalDAO();
        ConsultDAO consultDAO = new ConsultDAO();

        AnimalClinicService service = new AnimalClinicService(consultDAO, animalDAO);
        AnimalClinicController controller = new AnimalClinicController(service);

        System.out.println("Welkom in de dierenkliniek");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("Maak je keuze uit volgende opties");
            System.out.println("1 : voeg een kat toe");
            System.out.println("2 : voeg een hond toe");
            System.out.println("3 : toon alle dieren voor een eigenaar");
            System.out.println("4 : voer consultatie in");
            System.out.println("5 : toon alle consultaties voor een dier");
            System.out.println("6 : einde");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Voer de gegevens van de kat in:");
                    addCat(controller, scanner);
                    break;
                case 2:
                    System.out.println("Voer de gegevens van de hond in:");
                    addDog(controller, scanner);
                    break;
                case 3:
                    System.out.println("Eigenaar:");
                    String owner = scanner.nextLine();
                    List<AnimalDTO> animals = controller.findAllAnimalsForOwner(owner);
                    System.out.println(animals);
                    break;
                case 4:
                    System.out.println("Voer de consultatie in:");
                    addConsult(controller, scanner);
                    break;
                case 5:
                    System.out.println("Dier:");
                    int animalId = scanner.nextInt();
                    scanner.nextLine();
                    List<ConsultDTO> consults = controller.findAllConsultsForAnimal(animalId);
                    System.out.println(consults);
                    break;
                default:
                    choice = 6;
                    break;

            }
        }
    }

    private static void addCat(AnimalClinicController controller, Scanner scanner) {
        System.out.println("Naam:");
        String name = scanner.nextLine();
        System.out.println("Eigenaar:");
        String owner = scanner.nextLine();

        AnimalDTO dto = new AnimalDTO();
        dto.setName(name);
        dto.setType("CAT");
        dto.setOwner(owner);

        boolean succes = controller.createNewAnimal(dto);
        if (!succes) {
            System.out.println("Er bestaat al een kat met deze gegevens");
        }
    }

    private static void addDog(AnimalClinicController controller, Scanner scanner) {
        System.out.println("Naam:");
        String name = scanner.nextLine();
        System.out.println("Eigenaar:");
        String owner = scanner.nextLine();

        AnimalDTO dto = new AnimalDTO();
        dto.setName(name);
        dto.setType("DOG");
        dto.setOwner(owner);

        boolean succes = controller.createNewAnimal(dto);
        if (!succes) {
            System.out.println("Er bestaat al een hond met deze gegevens");
        }
    }

    private static void addConsult(AnimalClinicController controller, Scanner scanner) {
        System.out.println("ID dier:");
        int animalId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Consultatie (dd-mm-jjjj):");
        String date = scanner.nextLine();
        System.out.println("Reden:");
        String reason = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        ConsultDTO dto = new ConsultDTO();
        dto.setAnimalId(animalId);
        dto.setDate(LocalDate.parse(date, formatter));
        dto.setReason(reason);

        boolean succes = controller.createConsult(dto);
        if (!succes) {
            System.out.println("Consultatie voor onbekend dier");
        }
    }
}
