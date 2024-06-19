package ownerpets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File input = new File("src/main/resources/eigenaars.txt");

        try {
            List<Owner> strings = Files.lines(input.toPath())
                    .skip(1)
                    .map(line -> stringToOwner(line))
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(strings);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Owner stringToOwner(String line) {
        String[] split = line.split(";");
        return new Owner(split[0], "");
    }
}
