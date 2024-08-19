package incident;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Incident> list = new ArrayList<>();
        list.add(new Incident(Month.MAY, Location.HOGE_KEMPEN, BearType.BRUINE_BEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.APRIL, Location.GROENE_VALlEI, BearType.BRILBEER, AgressionType.INJURY, 3));
        list.add(new Incident(Month.OCTOBER, Location.BOSLAND, BearType.IJSBEER, AgressionType.INJURY, 2));
        list.add(new Incident(Month.APRIL, Location.GROENE_VALlEI, BearType.BRILBEER, AgressionType.MANSLAUGHTER, 4));
        list.add(new Incident(Month.NOVEMBER, Location.GROENE_VALlEI, BearType.TEDDYBEER, AgressionType.INJURY, 4));
        list.add(new Incident(Month.OCTOBER, Location.ZWINSTREEK, BearType.BRUINE_BEER, AgressionType.AGRESSION, 1));
        list.add(new Incident(Month.NOVEMBER, Location.HOGE_KEMPEN, BearType.BRILBEER, AgressionType.AGRESSION, 1));
        list.add(new Incident(Month.APRIL, Location.BOSLAND, BearType.BRILBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.JUNE, Location.GROENE_VALlEI, BearType.BRUINE_BEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.NOVEMBER, Location.HOGE_KEMPEN, BearType.REUZENPANDA, AgressionType.MANSLAUGHTER, 1));
        list.add(new Incident(Month.NOVEMBER, Location.GROENE_VALlEI, BearType.IJSBEER, AgressionType.MANSLAUGHTER, 2));
        list.add(new Incident(Month.NOVEMBER, Location.BOSLAND, BearType.BRILBEER, AgressionType.MANSLAUGHTER, 4));
        list.add(new Incident(Month.FEBRUARY, Location.ZWINSTREEK, BearType.IJSBEER, AgressionType.MANSLAUGHTER, 3));
        list.add(new Incident(Month.FEBRUARY, Location.BOSLAND, BearType.IJSBEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.FEBRUARY, Location.GROENE_VALlEI, BearType.BRUINE_BEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.JANUARY, Location.BOSLAND, BearType.REUZENPANDA, AgressionType.INJURY, 1));
        list.add(new Incident(Month.OCTOBER, Location.SCHELDEVALLEI, BearType.BRUINE_BEER, AgressionType.INJURY, 2));
        list.add(new Incident(Month.DECEMBER, Location.BOSLAND, BearType.TEDDYBEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.JULY, Location.HOGE_KEMPEN, BearType.IJSBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.JULY, Location.BOSLAND, BearType.TEDDYBEER, AgressionType.INJURY, 4));
        list.add(new Incident(Month.AUGUST, Location.ZWINSTREEK, BearType.BRUINE_BEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.MAY, Location.ZWINSTREEK, BearType.BRUINE_BEER, AgressionType.AGRESSION, 1));
        list.add(new Incident(Month.MAY, Location.HOGE_KEMPEN, BearType.BRUINE_BEER, AgressionType.INJURY, 3));
        list.add(new Incident(Month.JULY, Location.GROENE_VALlEI, BearType.BRUINE_BEER, AgressionType.INJURY, 2));
        list.add(new Incident(Month.FEBRUARY, Location.BOSLAND, BearType.BRILBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.NOVEMBER, Location.BOSLAND, BearType.BRILBEER, AgressionType.MANSLAUGHTER, 1));
        list.add(new Incident(Month.OCTOBER, Location.SCHELDEVALLEI, BearType.BRILBEER, AgressionType.MANSLAUGHTER, 1));
        list.add(new Incident(Month.SEPTEMBER, Location.GROENE_VALlEI, BearType.BRUINE_BEER, AgressionType.MANSLAUGHTER, 4));
        list.add(new Incident(Month.NOVEMBER, Location.HOGE_KEMPEN, BearType.BRILBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.APRIL, Location.BOSLAND, BearType.BRILBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.AUGUST, Location.SCHELDEVALLEI, BearType.TEDDYBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.MARCH, Location.BOSLAND, BearType.TEDDYBEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.MAY, Location.GROENE_VALlEI, BearType.TEDDYBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.JULY, Location.SCHELDEVALLEI, BearType.IJSBEER, AgressionType.MANSLAUGHTER, 4));
        list.add(new Incident(Month.JULY, Location.SCHELDEVALLEI, BearType.BRILBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.MARCH, Location.BOSLAND, BearType.REUZENPANDA, AgressionType.AGRESSION, 4));
        list.add(new Incident(Month.MAY, Location.BOSLAND, BearType.TEDDYBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.NOVEMBER, Location.ZWINSTREEK, BearType.IJSBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.FEBRUARY, Location.SCHELDEVALLEI, BearType.TEDDYBEER, AgressionType.INJURY, 4));
        list.add(new Incident(Month.MAY, Location.ZWINSTREEK, BearType.IJSBEER, AgressionType.AGRESSION, 4));
        list.add(new Incident(Month.MAY, Location.BOSLAND, BearType.IJSBEER, AgressionType.AGRESSION, 1));
        list.add(new Incident(Month.MARCH, Location.BOSLAND, BearType.BRUINE_BEER, AgressionType.AGRESSION, 1));
        list.add(new Incident(Month.SEPTEMBER, Location.SCHELDEVALLEI, BearType.IJSBEER, AgressionType.INJURY, 3));
        list.add(new Incident(Month.MARCH, Location.GROENE_VALlEI, BearType.REUZENPANDA, AgressionType.INJURY, 2));
        list.add(new Incident(Month.JULY, Location.HOGE_KEMPEN, BearType.TEDDYBEER, AgressionType.INJURY, 3));
        list.add(new Incident(Month.FEBRUARY, Location.ZWINSTREEK, BearType.TEDDYBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.NOVEMBER, Location.HOGE_KEMPEN, BearType.BRILBEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.MAY, Location.HOGE_KEMPEN, BearType.BRUINE_BEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.OCTOBER, Location.GROENE_VALlEI, BearType.REUZENPANDA, AgressionType.MANSLAUGHTER, 3));
        list.add(new Incident(Month.OCTOBER, Location.BOSLAND, BearType.TEDDYBEER, AgressionType.AGRESSION, 1));
        list.add(new Incident(Month.FEBRUARY, Location.HOGE_KEMPEN, BearType.REUZENPANDA, AgressionType.AGRESSION, 4));
        list.add(new Incident(Month.MARCH, Location.HOGE_KEMPEN, BearType.IJSBEER, AgressionType.MANSLAUGHTER, 4));
        list.add(new Incident(Month.MAY, Location.ZWINSTREEK, BearType.TEDDYBEER, AgressionType.MANSLAUGHTER, 4));
        list.add(new Incident(Month.DECEMBER, Location.HOGE_KEMPEN, BearType.REUZENPANDA, AgressionType.INJURY, 1));
        list.add(new Incident(Month.MARCH, Location.GROENE_VALlEI, BearType.BRUINE_BEER, AgressionType.INJURY, 2));
        list.add(new Incident(Month.JANUARY, Location.ZWINSTREEK, BearType.REUZENPANDA, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.DECEMBER, Location.BOSLAND, BearType.TEDDYBEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.APRIL, Location.SCHELDEVALLEI, BearType.IJSBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.SEPTEMBER, Location.GROENE_VALlEI, BearType.REUZENPANDA, AgressionType.MANSLAUGHTER, 2));
        list.add(new Incident(Month.JUNE, Location.HOGE_KEMPEN, BearType.TEDDYBEER, AgressionType.MANSLAUGHTER, 2));
        list.add(new Incident(Month.MARCH, Location.GROENE_VALlEI, BearType.REUZENPANDA, AgressionType.MANSLAUGHTER, 2));
        list.add(new Incident(Month.JUNE, Location.SCHELDEVALLEI, BearType.IJSBEER, AgressionType.INJURY, 3));
        list.add(new Incident(Month.FEBRUARY, Location.BOSLAND, BearType.BRUINE_BEER, AgressionType.INJURY, 3));
        list.add(new Incident(Month.MAY, Location.BOSLAND, BearType.REUZENPANDA, AgressionType.INJURY, 3));
        list.add(new Incident(Month.MARCH, Location.SCHELDEVALLEI, BearType.TEDDYBEER, AgressionType.AGRESSION, 4));
        list.add(new Incident(Month.FEBRUARY, Location.BOSLAND, BearType.BRILBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.SEPTEMBER, Location.GROENE_VALlEI, BearType.BRUINE_BEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.MAY, Location.SCHELDEVALLEI, BearType.IJSBEER, AgressionType.INJURY, 2));
        list.add(new Incident(Month.MARCH, Location.HOGE_KEMPEN, BearType.IJSBEER, AgressionType.MANSLAUGHTER, 2));
        list.add(new Incident(Month.AUGUST, Location.ZWINSTREEK, BearType.TEDDYBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.MARCH, Location.HOGE_KEMPEN, BearType.TEDDYBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.DECEMBER, Location.ZWINSTREEK, BearType.BRILBEER, AgressionType.MANSLAUGHTER, 4));
        list.add(new Incident(Month.AUGUST, Location.HOGE_KEMPEN, BearType.BRUINE_BEER, AgressionType.MANSLAUGHTER, 1));
        list.add(new Incident(Month.JANUARY, Location.SCHELDEVALLEI, BearType.IJSBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.JANUARY, Location.BOSLAND, BearType.REUZENPANDA, AgressionType.INJURY, 4));
        list.add(new Incident(Month.JULY, Location.BOSLAND, BearType.IJSBEER, AgressionType.AGRESSION, 4));
        list.add(new Incident(Month.MAY, Location.BOSLAND, BearType.BRILBEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.MARCH, Location.ZWINSTREEK, BearType.BRUINE_BEER, AgressionType.AGRESSION, 4));
        list.add(new Incident(Month.DECEMBER, Location.BOSLAND, BearType.IJSBEER, AgressionType.AGRESSION, 1));
        list.add(new Incident(Month.MAY, Location.ZWINSTREEK, BearType.BRILBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.JUNE, Location.SCHELDEVALLEI, BearType.BRUINE_BEER, AgressionType.AGRESSION, 2));
        list.add(new Incident(Month.JULY, Location.HOGE_KEMPEN, BearType.TEDDYBEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.NOVEMBER, Location.BOSLAND, BearType.TEDDYBEER, AgressionType.INJURY, 4));
        list.add(new Incident(Month.NOVEMBER, Location.BOSLAND, BearType.BRILBEER, AgressionType.MANSLAUGHTER, 3));
        list.add(new Incident(Month.SEPTEMBER, Location.ZWINSTREEK, BearType.BRILBEER, AgressionType.INJURY, 4));
        list.add(new Incident(Month.OCTOBER, Location.ZWINSTREEK, BearType.REUZENPANDA, AgressionType.AGRESSION, 1));
        list.add(new Incident(Month.SEPTEMBER, Location.GROENE_VALlEI, BearType.BRUINE_BEER, AgressionType.MANSLAUGHTER, 1));
        list.add(new Incident(Month.NOVEMBER, Location.SCHELDEVALLEI, BearType.BRILBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.MARCH, Location.BOSLAND, BearType.BRUINE_BEER, AgressionType.MANSLAUGHTER, 4));
        list.add(new Incident(Month.AUGUST, Location.ZWINSTREEK, BearType.REUZENPANDA, AgressionType.MANSLAUGHTER, 3));
        list.add(new Incident(Month.MARCH, Location.BOSLAND, BearType.IJSBEER, AgressionType.INJURY, 4));
        list.add(new Incident(Month.MAY, Location.BOSLAND, BearType.BRILBEER, AgressionType.AGRESSION, 3));
        list.add(new Incident(Month.MAY, Location.HOGE_KEMPEN, BearType.BRUINE_BEER, AgressionType.AGRESSION, 4));
        list.add(new Incident(Month.JANUARY, Location.GROENE_VALlEI, BearType.TEDDYBEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.FEBRUARY, Location.BOSLAND, BearType.TEDDYBEER, AgressionType.MANSLAUGHTER, 4));
        list.add(new Incident(Month.JULY, Location.GROENE_VALlEI, BearType.IJSBEER, AgressionType.INJURY, 2));
        list.add(new Incident(Month.OCTOBER, Location.GROENE_VALlEI, BearType.IJSBEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.OCTOBER, Location.BOSLAND, BearType.IJSBEER, AgressionType.INJURY, 3));
        list.add(new Incident(Month.OCTOBER, Location.GROENE_VALlEI, BearType.BRILBEER, AgressionType.INJURY, 1));
        list.add(new Incident(Month.APRIL, Location.ZWINSTREEK, BearType.BRUINE_BEER, AgressionType.AGRESSION, 1));

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
        System.out.println("Tel aantal incidenten voor Hoge Kempen in Q4 1P");
        System.out.println("----------------------");
        vraag4(list);
        System.out.println();

        System.out.println("----------------------");
        System.out.println("Totaal aantal dodelijke slachtoffers teddybeer 1P");
        System.out.println("----------------------");
        vraag5(list);
    }

    // 1P
    // Gebruik geen streams, enkel Collections en sorting
    // Pas de Incident klasse aan zodat die standaard sorteert op slachtoffers (victims) aflopend en beertype (bearType) alfabetisch.
    // Sorteer de lijst en print naar de console.
    private static void vraag1(List<Incident> list) {

        Collections.sort(list);
        for (Incident i : list) {
            System.out.println(i);
        }

    }

    // 1P
    // Gebruik geen streams, enkel Collections en sorting
    // Sorteer de lijst op maand (month) VOLGENS KALENDER en locatie (location) alfabetisch.
    // Sortering maand volgens kalender = januari, februari, maart, ...
    // Pas de Incident klasse niet aan!
    // Print de lijst naar de console.
    private static void vraag2(List<Incident> list) {

        list.sort((o1, o2) -> {
            //-X, 0, +X
            int result = o1.getMonth().compareTo(o2.getMonth());
            if(result == 0) {
                return o1.getLocation().compareTo(o2.getLocation());
            }
            return result;
        });
        System.out.println(list);

    }

    // 1P
    // Gebruik enkel streams
    // Verzamel alle incidenten voor bruine beren uit de lijst, sorteer deze incidenten op locatie alfabetisch en zorg dat er geen dubbels in zitten.
    // Print de lijst naar de console.
    private static void vraag3(List<Incident> list) {

        var inc = list.stream().filter(i -> i.getBearType() == BearType.BRUINE_BEER).sorted(Comparator.comparing(Incident::getLocation)).distinct().toList();
        System.out.println(inc);

    }

    // 1P
    // Gebruik enkel streams
    // Tel het aantal incidenten op van type injury voor de maanden oktober, november en december, let op dat je geen dubbels telt.
    // Print het resultaat naar de console.
    private static void vraag4(List<Incident> list) {

        List<Month> allowedMonths = new ArrayList<>();
        allowedMonths.add(Month.OCTOBER);
        allowedMonths.add(Month.NOVEMBER);
        allowedMonths.add(Month.DECEMBER);
        var c = list.stream().filter(i -> i.getAgressionType() == AgressionType.INJURY && allowedMonths.contains(i.getMonth())).distinct().count();
        System.out.println(c);

    }

    // 1P
    // Gebruik enkel streams
    // Bereken het totaal aantal dodelijke (manslaughter) slachtoffers van teddyberen.
    // Print het resultaat naar de console.
    private static void vraag5(List<Incident> list) {

        var c = list.stream().filter(i -> i.getBearType() == BearType.TEDDYBEER && i.getAgressionType() == AgressionType.MANSLAUGHTER).count();
        System.out.println(c);

    }
}
