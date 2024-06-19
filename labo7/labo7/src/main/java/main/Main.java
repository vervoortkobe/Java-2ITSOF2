package main;

import java.io.File;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BreedDAO dao = new BreedDAO();
        PutDogsInDB();
        System.out.println(dao.findAllBreeds());
    }
    public static void PutDogsInDB() {
        BreedDAO dao = new BreedDAO();
        File input = new File("src/main/resources/honden.csv");
        try {
            Files.lines(input.toPath())
                    .skip(1)
                    .forEach(l -> dao.createNew(stringToBreed(l)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Breed stringToBreed(String line) {
        String[] split = line.split(",");
        return new Breed(split[0], Double.valueOf(split[1]), Double.valueOf(split[2]), split[3]);
    }
}
