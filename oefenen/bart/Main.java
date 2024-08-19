package org.example;

import org.example.entity.Movie;
import org.example.entity.MovieDTO;
import org.example.entity.Regisseur;
import org.example.entity.RegisseurDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
       //MovieDTO.Add("81145628;Movie;Norm of the North: King Sized Adventure;Richard Finn, Tim Maltby;Alan Marriott, Andrew Toth, Brian Dobson, Cole Howard, Jennifer Cameron, Jonathan Holmes, Lee Tockar, Lisa Durupt, Maya Kay, Michael Dobson;United States, India, South Korea, China;September 9, 2019;2019;TV-PG;90 min;Children & Family Movies, Comedies;Before planning an awesome wedding for his grandfather, a polar bear king must take back a stolen artifact from an evil archaeologist first.");
       //MovieDTO.Add("14444444;Movie;Norm of the North: King Sized Adventure;Richard Finn, Tim Maltby;Alan Marriott, Jennifer Cameron, Jonathan Holmes, Lee Tockar, Lisa Durupt, Maya Kay, Michael Dobson;United States, India, South Korea, China;September 9, 2019;2019;TV-PG;90 min;Children & Family Movies, Comedies;Before planning an awesome wedding for his grandfather, a polar bear king must take back a stolen artifact from an evil archaeologist first.");
        internalizeFromFile();
        printAmount();


    }
    //CONSOLE APPICATION
    public static void ConsoleApp(){
        boolean running = true;
        while (running){
            System.out.println("Zoek voor data op: gebruik (1,2,3,4) als input");
            System.out.println("1. Zoeken op jaar");
            System.out.println("2. Zoeken op titel");
            System.out.println("3. Zoeken op regisseur");
            System.out.println("4. Einde");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch (input){

            }
        }
    }

    //HELP FUNCTIONS
    private static boolean isInteger(String value) {
        System.out.println("Answer: " + value);
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // DATA BASE + FILE READING
    private static  void printAmount(){
        System.out.println("---PRINT Amount---------------------------");
        int movie = MovieDTO.getAll().size();
        int regisseur = RegisseurDTO.getAllRegisseurs().size();
        System.out.println("Antaal Movies: " + movie);
        System.out.println("Antaal Regisseurs: " + regisseur);
    }
    private static  void printAll(){
        System.out.println("---PRINT ALL---------------------------");
        List<Movie> movies = MovieDTO.getAll();
        for(Movie movie : movies){
            System.out.println(movie.getShow_id());
            for(Regisseur reg : movie.getRegisseurs()) {
                System.out.println(reg);
            }
        }
    }
    private static void internalizeFromFile(){
        String filePath = "src/main/resources/netflix_titles.csv";

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            // SORT
            List<String> linesList = lines.skip(1)
                    .collect(Collectors.toList()); // Collect sorted lines into a List
            int count = 0;
            int size = linesList.size();
            boolean start = false;
            // Convert to Class
            for (String line : linesList) {
                count++;
                if(count == size/2){
                    System.out.println("50% done ...");
                    return;
                }
                MovieDTO.Add(line);
                if(!start){
                    start = true;
                    System.out.println("Prossesing data might take a while 'BUT IT'S WORKING!'...");
                }
            }
            System.out.println("DONE!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}