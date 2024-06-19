package main;

import dao.AnimalDAO;
import entity.Animal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        PutAnimalsInDb();
        AnimalDAO dao = new AnimalDAO();
        System.out.println(dao.findAll());
    }

    public static void PutAnimalsInDb() {
        AnimalDAO dao = new AnimalDAO();
        File input = new File("src/main/resources/animals.txt");
        try {
            Files.lines(input.toPath())
                    .skip(1)
                    .forEach(l -> dao.createNew(stringToAnimal(l)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Animal stringToAnimal(String line) {
        String[] split = line.split(",");
        return new Animal(split[0], Boolean.valueOf(split[1]));
    }
}
