package labo7.labo7_6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> lecturersList = new ArrayList<>();
        lecturersList.add(new Person("Kelly", "Casal", "kelly.casalmosteiro@ap.be"));
        lecturersList.add(new Person("Olga", "Coutrin", "olga.coutrin@ap.be"));
        lecturersList.add(new Person("Philippe", "Possemiers", "philippe.possemiers@ap.be"));

        Person result = lecturersList
                .stream()
                .filter(p -> p.getName().equals("Philippe Possemiers") && p.getEmail().equals("philippe.possemiers@ap.be"))
                .findAny()
                .orElse(new Person("Empty", "Empty", "Empty"));
        System.out.println(result.getName());
    }
}