package labo7.labo7_8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String newFileName = "src/main/resources/four-letter-words-filtered-and-sorted.txt";
        String fileName = "src/main/resources/four-letter-words.txt";
        Path newPath = Paths.get(newFileName);

        try {
            List<String> newList = Files.lines(Paths.get(fileName))
                    .filter(l -> l.contains("A"))
                    .sorted((l1, l2) -> l1.compareTo(l2))
                    .peek(System.out::println)
                    .collect(Collectors.toList());
            Files.write(newPath, newList, Charset.defaultCharset());
            System.out.println("");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}