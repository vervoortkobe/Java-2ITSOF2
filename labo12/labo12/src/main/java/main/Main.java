package main;

import dao.FilmDAO;
import dao.RegisseurDAO;
import entity.Film;
import entity.FilmType;
import entity.Regisseur;
import org.hibernate.persister.collection.mutation.UpdateRowsCoordinatorNoOp;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.RegisteredSynchronization;
import java.time.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.registry.Registry;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    private static int films = 0;
    private static int regisseurs = 0;

    public static void main(String[] args) {
        PutFilmsInDb();
        showMenu();
    }

    private static void showMenu() {
        FilmDAO filmDAO = new FilmDAO();
        RegisseurDAO regisseurDAO = new RegisseurDAO();
        Scanner s = new Scanner(System.in);
        int keuze = 0;
        do {
            switch (keuze) {
                case 1:
                    System.out.println("Geef jaar");
                    int jaar = s.nextInt();
                    s.next();
                    System.out.println(filmDAO.findYear(jaar));
                    break;
                case 2:
                    System.out.println("Geef titel");
                    String titel = s.next();
                    System.out.println(filmDAO.findTitle(titel));
                    break;
                case 3:
                    System.out.println("Geef naam");
                    String naam = s.next();
                    regisseurDAO.findRegisseur(naam);
                    break;

                default:
                    break;
            }

            System.out.println("" +
                    "-- Menu --\n" +
                    "Maak een keuze\n" +
                    "1. Zoeken op jaar\n" +
                    "2. Zoeken op titel\n" +
                    "3. Zoeken op regisseur\n" +
                    "4. Einde" +
                    "");
            keuze = s.nextInt();
            s.next();
        } while(keuze != 4);
    }

    private static void PutFilmsInDb() {
        FilmDAO dao = new FilmDAO();
        File input = new File("src/main/resources/netflix_titles.csv");
        try {
            Files.lines(input.toPath())
                    .skip(1)
                    .filter(l -> l.contains("Movie"))
                    .forEach(l -> dao.createNew(stringToFilm(l)));
            films++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print(films + " films geladen,\n" + regisseurs + " regisseurs geladen");
    }
    private static Film stringToFilm(String line) {
        if(line.contains("TV Show")) return null;
        String[] split = line.split(";");

        //id, type, title, director, cast, country, date added, release year, rating, duration, listed in, description
        //id, type, title, land, datum, uitgave jaar, omschrijving, regisseurs
        Film newFilm = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        newFilm = new Film(parseInt(
                split[0]),
                FilmType.valueOf(split[1]),
                split[2],
                split[5],
                LocalDate.parse(split[6], formatter),
                LocalDate.of(Integer.parseInt(split[7]), 1, 1),
                split[11],
                getRegisseurs(split[3], newFilm)
        );
        return newFilm;
    }
    private static Set<Regisseur> getRegisseurs(String line, Film film) {
        String[] split = line.split(",");
        Set<Regisseur> set = new HashSet<Regisseur>();
        for (String s : split) {
            regisseurs++;
            set.add(new Regisseur(s, film));
        }
        return set;
    }
}
