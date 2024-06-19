package bear;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<BearSpotting> list = new ArrayList<>();
        list.add(new BearSpotting(LocalDate.of(2023, 5, 22), BearType.TEDDYBEER, Location.ZWINSTREEK, 90));
        list.add(new BearSpotting(LocalDate.of(2023, 10, 29), BearType.BRUINE_BEER, Location.ZWINSTREEK, 95));
        list.add(new BearSpotting(LocalDate.of(2023, 9, 4), BearType.BRUINE_BEER, Location.ZWINSTREEK, 65));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 13), BearType.BRUINE_BEER, Location.GROENE_VALlEI, 85));
        list.add(new BearSpotting(LocalDate.of(2023, 1, 19), BearType.REUZENPANDA, Location.ZWINSTREEK, 70));
        list.add(new BearSpotting(LocalDate.of(2023, 6, 29), BearType.BRUINE_BEER, Location.ZWINSTREEK, 45));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 21), BearType.BRILBEER, Location.GROENE_VALlEI, 70));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 4), BearType.BRILBEER, Location.ZWINSTREEK, 85));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 15), BearType.BRUINE_BEER, Location.GROENE_VALlEI, 95));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 3), BearType.BRILBEER, Location.HOGE_KEMPEN, 15));
        list.add(new BearSpotting(LocalDate.of(2023, 5, 23), BearType.BRUINE_BEER, Location.BOSLAND, 55));
        list.add(new BearSpotting(LocalDate.of(2023, 6, 18), BearType.REUZENPANDA, Location.SCHELDEVALLEI, 55));
        list.add(new BearSpotting(LocalDate.of(2023, 9, 7), BearType.REUZENPANDA, Location.HOGE_KEMPEN, 50));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 20), BearType.IJSBEER, Location.SCHELDEVALLEI, 80));
        list.add(new BearSpotting(LocalDate.of(2023, 5, 25), BearType.TEDDYBEER, Location.BOSLAND, 45));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 16), BearType.IJSBEER, Location.GROENE_VALlEI, 45));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 20), BearType.TEDDYBEER, Location.BOSLAND, 70));
        list.add(new BearSpotting(LocalDate.of(2023, 2, 23), BearType.BRILBEER, Location.HOGE_KEMPEN, 20));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 19), BearType.REUZENPANDA, Location.HOGE_KEMPEN, 80));
        list.add(new BearSpotting(LocalDate.of(2023, 10, 13), BearType.TEDDYBEER, Location.GROENE_VALlEI, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 5, 24), BearType.REUZENPANDA, Location.HOGE_KEMPEN, 35));
        list.add(new BearSpotting(LocalDate.of(2023, 5, 28), BearType.TEDDYBEER, Location.SCHELDEVALLEI, 50));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 7), BearType.TEDDYBEER, Location.ZWINSTREEK, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 6, 26), BearType.BRILBEER, Location.GROENE_VALlEI, 100));
        list.add(new BearSpotting(LocalDate.of(2023, 2, 28), BearType.IJSBEER, Location.ZWINSTREEK, 10));
        list.add(new BearSpotting(LocalDate.of(2023, 11, 11), BearType.BRILBEER, Location.BOSLAND, 85));
        list.add(new BearSpotting(LocalDate.of(2023, 5, 9), BearType.REUZENPANDA, Location.HOGE_KEMPEN, 90));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 8), BearType.TEDDYBEER, Location.SCHELDEVALLEI, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 12, 25), BearType.TEDDYBEER, Location.SCHELDEVALLEI, 95));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 8), BearType.BRILBEER, Location.BOSLAND, 85));
        list.add(new BearSpotting(LocalDate.of(2023, 11, 6), BearType.BRUINE_BEER, Location.SCHELDEVALLEI, 90));
        list.add(new BearSpotting(LocalDate.of(2023, 2, 27), BearType.BRUINE_BEER, Location.HOGE_KEMPEN, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 11), BearType.TEDDYBEER, Location.HOGE_KEMPEN, 50));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 1), BearType.BRUINE_BEER, Location.HOGE_KEMPEN, 20));
        list.add(new BearSpotting(LocalDate.of(2023, 2, 20), BearType.IJSBEER, Location.GROENE_VALlEI, 55));
        list.add(new BearSpotting(LocalDate.of(2023, 8, 13), BearType.IJSBEER, Location.HOGE_KEMPEN, 80));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 10), BearType.REUZENPANDA, Location.ZWINSTREEK, 70));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 1), BearType.TEDDYBEER, Location.SCHELDEVALLEI, 45));
        list.add(new BearSpotting(LocalDate.of(2023, 12, 20), BearType.TEDDYBEER, Location.HOGE_KEMPEN, 5));
        list.add(new BearSpotting(LocalDate.of(2023, 2, 20), BearType.IJSBEER, Location.ZWINSTREEK, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 5, 24), BearType.IJSBEER, Location.ZWINSTREEK, 45));
        list.add(new BearSpotting(LocalDate.of(2023, 12, 15), BearType.IJSBEER, Location.HOGE_KEMPEN, 100));
        list.add(new BearSpotting(LocalDate.of(2023, 8, 1), BearType.REUZENPANDA, Location.ZWINSTREEK, 20));
        list.add(new BearSpotting(LocalDate.of(2023, 8, 12), BearType.BRILBEER, Location.ZWINSTREEK, 80));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 5), BearType.IJSBEER, Location.GROENE_VALlEI, 80));
        list.add(new BearSpotting(LocalDate.of(2023, 9, 21), BearType.TEDDYBEER, Location.ZWINSTREEK, 25));
        list.add(new BearSpotting(LocalDate.of(2023, 1, 16), BearType.BRILBEER, Location.SCHELDEVALLEI, 25));
        list.add(new BearSpotting(LocalDate.of(2023, 2, 1), BearType.IJSBEER, Location.BOSLAND, 75));
        list.add(new BearSpotting(LocalDate.of(2023, 2, 7), BearType.IJSBEER, Location.GROENE_VALlEI, 80));
        list.add(new BearSpotting(LocalDate.of(2023, 1, 13), BearType.REUZENPANDA, Location.SCHELDEVALLEI, 50));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 5), BearType.REUZENPANDA, Location.ZWINSTREEK, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 1, 21), BearType.BRILBEER, Location.HOGE_KEMPEN, 35));
        list.add(new BearSpotting(LocalDate.of(2023, 6, 29), BearType.BRUINE_BEER, Location.ZWINSTREEK, 45));
        list.add(new BearSpotting(LocalDate.of(2023, 11, 11), BearType.BRUINE_BEER, Location.ZWINSTREEK, 5));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 4), BearType.TEDDYBEER, Location.HOGE_KEMPEN, 65));
        list.add(new BearSpotting(LocalDate.of(2023, 8, 20), BearType.BRILBEER, Location.SCHELDEVALLEI, 30));
        list.add(new BearSpotting(LocalDate.of(2023, 2, 7), BearType.IJSBEER, Location.ZWINSTREEK, 35));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 26), BearType.REUZENPANDA, Location.GROENE_VALlEI, 30));
        list.add(new BearSpotting(LocalDate.of(2023, 8, 9), BearType.IJSBEER, Location.SCHELDEVALLEI, 60));
        list.add(new BearSpotting(LocalDate.of(2023, 1, 9), BearType.TEDDYBEER, Location.HOGE_KEMPEN, 65));
        list.add(new BearSpotting(LocalDate.of(2023, 9, 14), BearType.TEDDYBEER, Location.GROENE_VALlEI, 60));
        list.add(new BearSpotting(LocalDate.of(2023, 12, 20), BearType.REUZENPANDA, Location.ZWINSTREEK, 35));
        list.add(new BearSpotting(LocalDate.of(2023, 6, 16), BearType.TEDDYBEER, Location.GROENE_VALlEI, 65));
        list.add(new BearSpotting(LocalDate.of(2023, 10, 7), BearType.IJSBEER, Location.ZWINSTREEK, 100));
        list.add(new BearSpotting(LocalDate.of(2023, 6, 8), BearType.BRUINE_BEER, Location.SCHELDEVALLEI, 100));
        list.add(new BearSpotting(LocalDate.of(2023, 10, 17), BearType.REUZENPANDA, Location.GROENE_VALlEI, 90));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 24), BearType.TEDDYBEER, Location.HOGE_KEMPEN, 70));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 18), BearType.IJSBEER, Location.ZWINSTREEK, 70));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 11), BearType.IJSBEER, Location.SCHELDEVALLEI, 25));
        list.add(new BearSpotting(LocalDate.of(2023, 1, 28), BearType.BRUINE_BEER, Location.GROENE_VALlEI, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 5, 23), BearType.BRUINE_BEER, Location.SCHELDEVALLEI, 15));
        list.add(new BearSpotting(LocalDate.of(2023, 12, 23), BearType.IJSBEER, Location.HOGE_KEMPEN, 90));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 27), BearType.IJSBEER, Location.BOSLAND, 75));
        list.add(new BearSpotting(LocalDate.of(2023, 8, 15), BearType.TEDDYBEER, Location.BOSLAND, 65));
        list.add(new BearSpotting(LocalDate.of(2023, 8, 13), BearType.REUZENPANDA, Location.HOGE_KEMPEN, 25));
        list.add(new BearSpotting(LocalDate.of(2023, 10, 26), BearType.REUZENPANDA, Location.GROENE_VALlEI, 100));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 5), BearType.BRILBEER, Location.ZWINSTREEK, 100));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 24), BearType.TEDDYBEER, Location.SCHELDEVALLEI, 55));
        list.add(new BearSpotting(LocalDate.of(2023, 9, 16), BearType.TEDDYBEER, Location.HOGE_KEMPEN, 70));
        list.add(new BearSpotting(LocalDate.of(2023, 12, 20), BearType.IJSBEER, Location.SCHELDEVALLEI, 20));
        list.add(new BearSpotting(LocalDate.of(2023, 7, 16), BearType.BRILBEER, Location.BOSLAND, 45));
        list.add(new BearSpotting(LocalDate.of(2023, 11, 21), BearType.BRUINE_BEER, Location.ZWINSTREEK, 15));
        list.add(new BearSpotting(LocalDate.of(2023, 1, 3), BearType.BRILBEER, Location.ZWINSTREEK, 20));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 21), BearType.BRILBEER, Location.SCHELDEVALLEI, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 10), BearType.TEDDYBEER, Location.BOSLAND, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 3, 24), BearType.BRUINE_BEER, Location.HOGE_KEMPEN, 10));
        list.add(new BearSpotting(LocalDate.of(2023, 5, 5), BearType.BRILBEER, Location.SCHELDEVALLEI, 15));
        list.add(new BearSpotting(LocalDate.of(2023, 1, 16), BearType.IJSBEER, Location.GROENE_VALlEI, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 8), BearType.BRILBEER, Location.GROENE_VALlEI, 90));
        list.add(new BearSpotting(LocalDate.of(2023, 12, 21), BearType.REUZENPANDA, Location.GROENE_VALlEI, 90));
        list.add(new BearSpotting(LocalDate.of(2023, 6, 10), BearType.IJSBEER, Location.SCHELDEVALLEI, 80));
        list.add(new BearSpotting(LocalDate.of(2023, 4, 17), BearType.TEDDYBEER, Location.ZWINSTREEK, 35));
        list.add(new BearSpotting(LocalDate.of(2023, 5, 12), BearType.TEDDYBEER, Location.HOGE_KEMPEN, 45));
        list.add(new BearSpotting(LocalDate.of(2023, 9, 19), BearType.REUZENPANDA, Location.SCHELDEVALLEI, 35));
        list.add(new BearSpotting(LocalDate.of(2023, 6, 29), BearType.BRILBEER, Location.BOSLAND, 40));
        list.add(new BearSpotting(LocalDate.of(2023, 6, 6), BearType.TEDDYBEER, Location.GROENE_VALlEI, 25));
        list.add(new BearSpotting(LocalDate.of(2023, 11, 28), BearType.TEDDYBEER, Location.BOSLAND, 75));
        list.add(new BearSpotting(LocalDate.of(2023, 10, 21), BearType.BRUINE_BEER, Location.SCHELDEVALLEI, 65));
        list.add(new BearSpotting(LocalDate.of(2023, 12, 9), BearType.TEDDYBEER, Location.ZWINSTREEK, 50));
        list.add(new BearSpotting(LocalDate.of(2023, 1, 6), BearType.IJSBEER, Location.GROENE_VALlEI, 5));

        System.out.println("--------------------");
        System.out.println("Demo output");
        System.out.println("--------------------");
        list.forEach(System.out::println);
        System.out.println();

        System.out.println("--------------------");
        System.out.println("Standaard sortering 1P");
        System.out.println("--------------------");
        vraag1(list);
        System.out.println();

        System.out.println("----------------");
        System.out.println("Custom sortering 1P");
        System.out.println("----------------");
        vraag2(list);
        System.out.println();

        System.out.println("------------------------");
        System.out.println("Bruine beren, gesorteerd, geen duplicaten 1P");
        System.out.println("------------------------");
        vraag3(list);
        System.out.println();

        System.out.println("----------------------");
        System.out.println("Tel aantal waarnemingen voor Hoge Kempen 1P");
        System.out.println("----------------------");
        vraag4(list);
        System.out.println();

        System.out.println("----------------------");
        System.out.println("Gemiddelde van zekerheid waarneming teddybeer 1P");
        System.out.println("----------------------");
        vraag5(list);
    }

    // 1P
    // Gebruik geen streams, enkel Collections en sorting
    // Pas de BearSpotting klasse aan zodat die standaard sorteert op datum (date) aflopend en beertype (type) alfabetisch.
    // Sorteer de lijst en print naar de console.
    private static void vraag1(List<BearSpotting> list) {

        //System.out.println(list.sort(Comparator.naturalOrder()));

    }

    // 1P
    // Gebruik geen streams, enkel Collections en sorting
    // Sorteer de lijst op locatie (location) alfabetisch en zekerheid (accuracy) oplopend.
    // Pas de BearSpotting klasse niet aan!
    // Print de lijst naar de console.
    private static void vraag2(List<BearSpotting> list) {

        //System.out.println(list.sort(Comparator.comparing(BearSpotting::getLocation)));

    }

    // 1P
    // Gebruik enkel streams
    // Verzamel alle waarnemingen voor bruine beren uit de lijst, sorteer deze waarnemingen op datum oplopend en zorg dat er geen dubbels in zitten.
    // Print de lijst naar de console.
    private static void vraag3(List<BearSpotting> list) {

        System.out.println(
                list.stream()
                        .sorted(Comparator.comparing(BearSpotting::getDate).reversed())
                        .distinct()
                        .collect(Collectors.toList())
        );

    }

    // 1P
    // Gebruik enkel streams
    // Tel het aantal waarnemingen voor locatie Hoge Kempen met een zekerheid (accuracy) groter of gelijk aan 70%, hou rekening met dubbels.
    // Print het resultaat naar de console.
    private static void vraag4(List<BearSpotting> list) {

        System.out.println(
                list.stream()
                        .filter(o -> o.getAccuracy() >= 70) //er van uit gaande dat percenten in decimals worden weergegeven (int)
                        .distinct()
                        .count()
        );

    }

    // 1P
    // Gebruik enkel streams
    // Bereken de gemiddelde zekerheid (accuracy) van waarnemingen van teddyberen in de periode van januari (01-01-2023) tot en met juni (30-06-2023).
    // Print het resultaat naar de console.
    private static void vraag5(List<BearSpotting> list) {

        System.out.println(
                list.stream()
                        .filter(o -> o.getDate().isAfter(LocalDate.of(2023, 1, 1)) && o.getDate().isBefore(LocalDate.of(2023, 6, 30)))
                        .collect(Collectors.averagingDouble(BearSpotting::getAccuracy))
        );

    }
}
