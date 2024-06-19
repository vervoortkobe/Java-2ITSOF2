import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import animalShelter.*;
import animalClasses.*;
import animalShelter.AnimalShelter;
import animals.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        Integer input = 0;
        while (input != 6) {
            System.out.println("WELKOM BIJ HET DIERENASIEL!!\n" +
                    "Selecteer een optie:" +
                    "1 : voeg een kat toe\n" +
                    "2 : voeg een hond toe\n" +
                    "3 : toon alle dieren\n" +
                    "4 : toon dier\n" +
                    "5 : verwijder dier\n" +
                    "6 : einde\n" +
                    ">>>");
            input = scanner.nextInt();
            scanner.nextLine();
            System.out.println(input);
            switch (input) {
                case 1:
                    System.out.println("Kat naam?");
                    String katnaam = scanner.nextLine();
                    System.out.println("Kat geboortedatum? (dd-MM-yyyy)");
                    String katbd = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    System.out.println("Kat gender?");
                    String katgenderstr = scanner.nextLine();
                    Gender katgender = Gender.valueOf(katgenderstr.toUpperCase());
                    System.out.println("Kat breed?");
                    String katbreedstr = scanner.nextLine();
                    CatBreed katbreed = CatBreed.valueOf(katbreedstr.toUpperCase());

                    shelter.addCat(new Cat(katnaam, LocalDate.parse(katbd, formatter), katgender, katbreed));
                    break;
                case 2:
                    break;

                /*System.out.println("Geef het ras in");
                String breed = scanner.NextLine();
                CatBreed catBreed = CatBreed.valueOf(breed.toUpperCase());*/
            }
        }
    }
}
