package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        File input = new File("src/main/resources/four-letter-words.txt");
        File output = new File("src/main/resources/output.txt");
        File output2 = new File("src/main/resources/output2.txt");

        //deel 1
        try {
            List<String> strings = Files.lines(input.toPath())
                    .filter(word -> word.contains("A"))
                    .sorted()
                    .map(word -> word.toLowerCase())
                    .collect(Collectors.toList());
            Files.write(output.toPath(), strings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //deel 2
        try {
            List<String> strings = Files.lines(input.toPath())
                    .filter(word -> isPalindrome(word))
                    .collect(Collectors.toList());
            Files.write(output2.toPath(), strings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isPalindrome(String word)
    {
        return new StringBuilder(word).reverse().toString().equals(word);
    }
}
