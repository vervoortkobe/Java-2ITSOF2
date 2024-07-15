package labo7.labo7_7;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String newFileName = "src/main/resources/four-letter-words-filtered.txt";
        String fileName = "src/main/resources/four-letter-words.txt";
        Path newPath = Paths.get(newFileName);

        try {
            List<String> newList = Files.lines(Paths.get(fileName))
                    .filter(l -> l.contains("A"))
                    .peek(System.out::println)
                    .collect(Collectors.toList());
            Files.write(newPath, newList);
            System.out.println("");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}