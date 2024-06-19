package shelter;

import animals.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welkom in dierenasiel");
        AnimalShelter shelter = new AnimalShelter();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("Maak je keuze uit volgende opties");
            System.out.println("1 : voeg een kat toe");
            System.out.println("2 : voeg een hond toe");
            System.out.println("3 : toon alle dieren");
            System.out.println("4 : toon dier");
            System.out.println("5 : verwijder dier");
            System.out.println("6 : einde");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Voer de gegevens van de kat in:");
                    addCat(shelter, scanner);
                    break;
                case 2:
                    System.out.println("Voer de gegevens van de hond in:");
                    addDog(shelter, scanner);
                    break;
                case 3:
                    System.out.println("De dieren in het asiel zijn:");
                    shelter.printAllAnimals();
                    break;
                case 4:
                    System.out.println("Geef de index van het te tonen dier:");
                    int showIndex = scanner.nextInt();
                    shelter.showAnimal(showIndex);
                    break;
                case 5:
                    System.out.println("Geef de index van het te verwijderen dier:");
                    int deleteIndex = scanner.nextInt();
                    shelter.removeAnimal(deleteIndex);
                    break;
                default:
                    choice = 6;
                    break;

            }
        }
    }

    private static void addCat(AnimalShelter shelter, Scanner scanner) {
        System.out.println("Naam:");
        String name = scanner.nextLine();
        System.out.println("Ras (PERSIAN, RAGDOLL, BENGAL, SIAMESE of SPHYNX):");
        CatBreed breed = CatBreed.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Geboortedatum (formaat dd-mm-jjjj):");
        String birthDate = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(birthDate, formatter);
        System.out.println("Geslacht (MALE, FEMALE, MALE_NEUTERED of FEMALE_NEUTERED):");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        shelter.addCat(new Cat(name, breed, gender, date));
    }

    private static void addDog(AnimalShelter shelter, Scanner scanner) {
        System.out.println("Naam:");
        String name = scanner.nextLine();
        System.out.println("Ras (LABRADOR_RETRIEVER, BULLDOG, POODLE, BEAGLE of GERMAN_SHEPHERD):");
        DogBreed breed = DogBreed.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Geboortedatum (formaat dd-mm-jjjj):");
        String birthDate = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(birthDate, formatter);
        System.out.println("Geslacht (MALE, FEMALE, MALE_NEUTERED of FEMALE_NEUTERED):");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        shelter.addDog(new Dog(name, breed, gender, date));
    }
}
