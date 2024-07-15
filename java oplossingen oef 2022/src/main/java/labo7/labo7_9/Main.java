package labo7.labo7_9;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String newFileName = "src/main/resources/four-letter-words-filtered-on-palindrome.txt";
        String fileName = "src/main/resources/four-letter-words.txt";
        Path newPath = Paths.get(newFileName);

        try {
            List<String> newList3 = Files.lines(Paths.get(fileName))
                    .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                    .peek(System.out::println)
                    .collect(Collectors.toList());
            Files.write(newPath, newList3, Charset.defaultCharset());
            System.out.println("");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}