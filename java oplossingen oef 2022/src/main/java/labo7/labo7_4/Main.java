package labo7.labo7_4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> lecturersList = new ArrayList<>();
        lecturersList.add(new Person("Kelly", "Casal", "kelly.casalmosteiro@ap.be"));
        lecturersList.add(new Person("Olga", "Coutrin", "olga.coutrin@ap.be"));
        lecturersList.add(new Person("Philippe", "Possemiers", "philippe.possemiers@ap.be"));

        lecturersList
                .stream()
                .filter(p -> p.getEmail().equals("philippe.possemiers@ap.be"))
                .map(p -> p.getName())
                .forEach(System.out::println);
    }
}