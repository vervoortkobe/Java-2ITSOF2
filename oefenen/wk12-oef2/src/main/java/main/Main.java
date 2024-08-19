package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("De Kapellekensbaan", "Louis Paul Boon", 1953),
                new Book("Het verdriet van België", "Hugo Claus", 1983),
                new Book("De leeuw van Vlaanderen", "Hendrik Conscience", 1838),
                new Book("Kaas", "Willem Elsschot", 1933),
                new Book("Een revolverschot", "Virginie Loveling", 1911),
                new Book("Dood van een non", "Maria Rosseels", 1961),
                new Book("Meester Mitraillette", "Jan Vantoortelboom", 2014),
                new Book("Oorlog en vrede", "Lev Nikolajevitsj Tolstoj", 1985),
                new Book("Hersenschimmen", "J. Bernlef", 2009),
                new Book("Verhalen", "Isaak Babel", 2013),
                new Book("Publieke werken", "Thomas Rosenboom", 1999),
                new Book("Max Havelaar", "Multatuli", 1899),
                new Book("Dode zielen", "Nikolaj Gogol", 1900),
                new Book("De avonden", "Gerard Reve", 1947),
                new Book("Het stenen bruidsbed", "Harry Mulisch", 1900),
                new Book("Een revolverschot", "Bob Ross", 1995),
                new Book("De welwillenden", "Jonathan Littell", 2008),
                new Book("De donkere kamer van Damokles", "Willem Frederik Hermans", 1994),
                new Book("Dode zielen", "Nikolaj Gogol", 1900),
                new Book("Honderd jaar eenzaamheid", "Gabriel García Márquez", 1900),
                new Book("De goddelijke komedie", "Dante Alighieri", 2009),
                new Book("De Kapellekensbaan", "Louis Paul Boon", 1953));

        System.out.println("--------------------");
        System.out.println("Demo output");
        System.out.println("--------------------");
        books.forEach(System.out::println);
        System.out.println();

        System.out.println("--------------------");
        System.out.println("Standaard sortering 1P");
        System.out.println("--------------------");
        defaultSorting(books);
        System.out.println();

        System.out.println("----------------");
        System.out.println("Custom sortering 1P");
        System.out.println("----------------");
        customSorting(books);
        System.out.println();

        System.out.println("------------------------");
        System.out.println("Books no duplicates 1P");
        System.out.println("------------------------");
        removeDuplicates(books);
        System.out.println();

        System.out.println("----------------------");
        System.out.println("Books before 1950 1P");
        System.out.println("----------------------");
        booksBefore(books);
        System.out.println();

        System.out.println("----------------------");
        System.out.println("Count books with 'D' between 1950 and 1980 1P");
        System.out.println("----------------------");
        countBooks(books);
    }

    // 1P
    // Gebruik geen streams, enkel Collections en sorting
    // Pas de Book class aan zodat die standaard sorteert op title alfabetisch.
    // Sorteer de lijst en print naar de console.
    private static void defaultSorting(List<Book> books) {

        Collections.sort(books);
        books.forEach(System.out::println);

    }

    // 1P
    // Gebruik geen streams, enkel Collections en sorting
    // Sorteer de lijst op year aflopend en author omgekeerd alfabetisch
    // Pas de Book class niet aan!
    // Print de lijst naar de console.
    private static void customSorting(List<Book> books) {

        Collections.sort(books, new BookComparator());
        books.forEach(System.out::println);

    }

    // 1P
    // Gebruik enkel streams
    // Zorg er voor dat de items uit books in een collectie zonder duplicaten komen.
    // Pas indien nodig de Book class aan, maar zorg dat bovenstaande opgaves
    // blijven werken.
    // Print de collectie naar de console.
    private static void removeDuplicates(List<Book> books) {

        var b = books.stream().distinct().collect(Collectors.toList());
        System.out.println(b);

    }

    // 1P
    // Gebruik enkel streams
    // Maak een collectie met alle boektitels van boeken voor 1950, verwijderd
    // duplicaten en sorteer deze op year oplopend.
    // Print deze lijst naar de console.
    private static void booksBefore(List<Book> books) {

        System.out.println(books.stream().filter(b -> b.getReleaseYear() < 1950).distinct().sorted(Comparator.comparingInt(Book::getReleaseYear)).toList());

    }

    // 1P
    // Gebruik enkel streams
    // Bereken het aantal unieke boeken waarvan de title met een 'D' begint en
    // geschreven zijn tussen 1950 en 1980.
    // Print het resultaat (= één getal) naar de console.
    private static void countBooks(List<Book> books) {

        System.out.println(books.stream().distinct().filter(b -> b.getTitle().startsWith("D") && b.getReleaseYear() > 1950 && b.getReleaseYear() < 1980).count());

    }
}

