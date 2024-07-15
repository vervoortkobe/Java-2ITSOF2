package labo7.labo7_5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> lecturersList = new ArrayList<>();
        lecturersList.add(new Person("Kelly", "Casal", "kelly.casalmosteiro@ap.be"));
        lecturersList.add(new Person("Olga", "Coutrin", "olga.coutrin@ap.be"));
        lecturersList.add(new Person("Philippe", "Possemiers", "philippe.possemiers@ap.be"));

        List<Person> newLecturersList = lecturersList
                .stream()
                .filter(p -> p.getEmail().equals("philippe.possemiers@ap.be"))
                .collect(Collectors.toList());
        newLecturersList.forEach(p -> System.out.println(p.getName()));
    }
}