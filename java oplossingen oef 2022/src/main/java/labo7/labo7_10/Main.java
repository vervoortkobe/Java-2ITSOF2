package labo7.labo7_10;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<City> cities = new ArrayList<>();
        cities.add(new City("New York",8550405, 86443));
        cities.add(new City("Boston",754987, 3864));
        cities.add(new City("Los Angeles",5439768, 1043));
        cities.add(new City("Chicago",2720546, 87));
        cities.add(new City("San Diego",1394928, 86443));

        cities
                .stream()
                .filter(c -> c.getNrOfPeople() > 4000000 && c.getNrOfCrimes() < 8000)
                .map(c -> c.getName())
                .forEach(System.out::println);
        System.out.println("");
    }
}