package meteo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Temperature> list = new ArrayList<>();
        //bron : https://meteostat.net/
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 1), 10.0, 12.5, 15));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 2), 6.0, 9.6, 13));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 3), 3.0, 6.9, 9));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 4), 9.0, 11.3, 13));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 5), 10.0, 11.0, 11.8));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 6), 10.0, 11.0, 11.0));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 7), 9.0, 10.6, 12.0));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 8), 6.0, 8.8, 10.0));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 9), 5.0, 6.9, 9.0));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 10), 4.0, 6.3, 11.0));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 11), 8.0, 12.2, 12.0));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 12), 9.0, 9.8, 11.0));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 13), 7.0, 8.5, 9.0));
        list.add(new Temperature(Location.ANTWERPEN, LocalDate.of(2023, 1, 14), 6.0, 8.8, 12.0));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 1), 10.9, 12.8, 15));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 2), 5.6, 9.7, 13.4));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 3), 4.4, 6.9, 9.3));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 4), 9, 10.9, 12.3));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 5), 9.6, 10.5, 11.9));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 6), 9.2, 10.5, 11.7));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 7), 7.6, 9.3, 10.7));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 8), 7.6, 8.7, 10.0));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 9), 4.3, 6.4, 7.5));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 10), 2.6, 5.5, 10.5));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 11), 8.2, 9.7, 11.5));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 12), 8.4, 9.7, 10.6));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 13), 6.0, 7.8, 9.7));
        list.add(new Temperature(Location.BRUSSEL, LocalDate.of(2023, 1, 14), 5.3, 8.6, 11.7));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 1), 11.4, 13.3, 15.2));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 2), 6.2, 10.4, 14.4));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 3), 4.3, 6.9, 9.1));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 4), 8.9, 10.8, 12.6));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 5), 9.6, 10.6, 11.6));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 6), 9.3, 10.5, 11.3));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 7), 7.9, 9.7, 11.1));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 8), 8.0, 9.3, 10.5));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 9), 5.1, 6.8, 8.0));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 10), 2.9, 5.4, 9.7));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 11), 8.3, 9.9, 11.4));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 12), 8.4, 9.7, 10.5));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 13), 6.7, 8.1, 9.9));
        list.add(new Temperature(Location.HASSELT, LocalDate.of(2023, 1, 14), 5.5, 8.6, 11.8));

        System.out.println("--------------------");
        System.out.println("Demo output");
        System.out.println("--------------------");
        list.forEach(System.out::println);
        System.out.println("");

        System.out.println("--------------------");
        System.out.println("Standaard sortering 1P");
        System.out.println("--------------------");
        defaultSorting(list);
        System.out.println("");

        System.out.println("----------------");
        System.out.println("Custom sortering 1P");
        System.out.println("----------------");
        customSorting(list);
        System.out.println("");

        System.out.println("------------------------");
        System.out.println("Maximum temperaturen, oplopend gesorteerd 1P");
        System.out.println("------------------------");
        maxTemperatures(list);
        System.out.println("");

        System.out.println("----------------------");
        System.out.println("Tel aantal metingen voor Antwerpen 1P");
        System.out.println("----------------------");
        countAntwerp(list);

        System.out.println("----------------------");
        System.out.println("Gemiddelde minimum temperatuur voor Brussel in eerste week van januari (01/01/2023 -> 07/01/2023) 1P");
        System.out.println("----------------------");
        averageTemperatureBrusselsFirstWeekJanuary(list);
    }

    // 1P
    // Pas de Temperature klasse aan zodat die standaard sorteert op datum (date) aflopend en locatie (location) alfabetisch.
    // Sorteer de lijst en print naar de console.
    private static void defaultSorting(List<Temperature> list) {

        list.stream()
                .sorted()
                .forEach(System.out::println);

    }

    // 1P
    // Sorteer de lijst op minimum temperatuur (min) oplopend en datum (date) aflopend.
    // Pas de Temperature klasse niet aan!
    // Print de lijst naar de console.
    private static void customSorting(List<Temperature> list) {

        list.stream()
                .sorted(new SortByMinTempAndDateComparer())
                .forEach(System.out::println);

    }

    // 1P
    // Streams & Lambdas
    // Verzamel alle maximum temperaturen uit de lijst, sorteer deze oplopend en zorg dat er geen dubbels in zitten.
    // Print de lijst naar de console.
    private static void maxTemperatures(List<Temperature> list) {

        list.stream()
                .map(e -> e.getMax())
                .sorted()
                .distinct()
                .forEach(System.out::println);

    }

    // 1P
    // Streams & Lambdas
    // Tel het aantal metingen voor Antwerpen.
    // Print het resultaat naar de console.
    private static void countAntwerp(List<Temperature> list) {

        System.out.println(list.stream()
                .filter(e -> e.getLocation() == Location.ANTWERPEN)
                .count());

    }

    // 1P
    // Streams & Lambdas
    // Bepaal de gemiddelde minimum temperatuur van Brussel tijdens de eerste week van januari : 01/01/2023 tot en met 07/01/2023.
    // Print het resultaat (= één getal) naar de console.
    private static void averageTemperatureBrusselsFirstWeekJanuary(List<Temperature> list) {

        list.stream()
                .filter(e -> e.getLocation() == Location.BRUSSEL)
                .filter(e ->
                        e.getDate().isAfter(LocalDate.of(2023, 01, 01)) &&
                        e.getDate().isBefore(LocalDate.of(2023, 01, 07)))
                .mapToDouble(e -> e.getMin())
                .average()
                .ifPresent(System.out::println);

    }
}
