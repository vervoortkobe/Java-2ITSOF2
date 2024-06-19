package zoo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Bonobo> bonobos = new ArrayList<>();
        bonobos.add(new Bonobo(1, "Hortense", LocalDate.of(1978, 6, 16), Gender.FEMALE));
        bonobos.add(new Bonobo(2, "Banya", LocalDate.of(1990, 2, 1), Gender.FEMALE));
        bonobos.add(new Bonobo(3, "Vifijo", LocalDate.of(1994, 7, 23), Gender.MALE));
        bonobos.add(new Bonobo(4, "Djanoa", LocalDate.of(1995, 3, 27), Gender.FEMALE));
        bonobos.add(new Bonobo(5, "Binti", LocalDate.of(1995, 8, 14), Gender.FEMALE));
        bonobos.add(new Bonobo(6, "Zamba", LocalDate.of(1998, 4, 16), Gender.MALE));
        bonobos.add(new Bonobo(7, "Busira", LocalDate.of(2004, 2, 16), Gender.FEMALE));
        bonobos.add(new Bonobo(8, "Kianga", LocalDate.of(2005, 7, 17), Gender.FEMALE));
        bonobos.add(new Bonobo(9, "Habari", LocalDate.of(2006, 1, 29), Gender.MALE));
        bonobos.add(new Bonobo(10, "Nayembi", LocalDate.of(2006, 4, 26), Gender.FEMALE));
        bonobos.add(new Bonobo(11, "Moko", LocalDate.of(2013, 2, 20), Gender.MALE));
        bonobos.add(new Bonobo(12, "Kikongo", LocalDate.of(2014, 1, 29), Gender.MALE));
        bonobos.add(new Bonobo(13, "Bina", LocalDate.of(2015, 4, 3), Gender.FEMALE));
        bonobos.add(new Bonobo(14, "Nila", LocalDate.of(2015, 8, 29), Gender.FEMALE));
        bonobos.add(new Bonobo(15, "Mokonzi", LocalDate.of(2016, 2, 16), Gender.MALE));
        bonobos.add(new Bonobo(16, "Sanza", LocalDate.of(2017, 1, 31), Gender.FEMALE));
        bonobos.add(new Bonobo(17, "Balina", LocalDate.of(2019, 12, 7), Gender.FEMALE));
        bonobos.add(new Bonobo(18, "Unabii", LocalDate.of(2019, 12, 28), Gender.FEMALE));
        bonobos.add(new Bonobo(19, "Wakati", LocalDate.of(2021, 1, 1), Gender.FEMALE));
        bonobos.add(new Bonobo(20, "Xolani", LocalDate.of(2022, 1, 1), Gender.FEMALE));
/*
        // DEEL 1
        // oef 1
        // Zorg er voor dat de standaard sortering vna Bonobo op naam is,
        // sorteer de lijst en toon deze.
        // Controleer of de sortering correct is.
        bonobos.stream()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // oef 2
        bonobos.stream()
                .sorted(((o1, o2) -> {
                    int compare = o1.getDateOfBirth().getYear() - o2.getDateOfBirth().getYear();
                    if(compare == 0) return o1.compareTo(o2);
                    return compare;
                }))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // oef 3
        bonobos.stream()
                .filter(bonobo -> bonobo.getGender() == Gender.MALE)
                .sorted(Comparator.comparingInt(Bonobo::getId).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // oef 4
        bonobos.stream()
                .filter(bonobo -> bonobo.getDateOfBirth().isAfter(LocalDate.of(1999, 12, 13)) &&
                        bonobo.getDateOfBirth().isBefore(LocalDate.of(2011,1,1)))
                .map(Bonobo::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // oef 5
        bonobos.stream()
                .map(bonobo -> bonobo.getDateOfBirth().getYear())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // oef 6
        bonobos.stream()
                .filter(bonobo -> bonobo.getName().startsWith("B"))
                .sorted()
                .findFirst()
                .orElse(null);

        // oef 7
        bonobos.stream()
                .filter(bonobo -> bonobo.getDateOfBirth().getYear() == 2000)
                .forEach(System.out::println);

        // oef 8
        System.out.println(bonobos.stream()
                .collect(Collectors.averagingDouble(Bonobo::getAge)));

        // oef 9
        bonobos.stream()
                .collect(Collectors.groupingBy(Bonobo::getGender, Collectors.counting()))
                .forEach((b, count) -> System.out.println(b + ": " + count));
*/
        // DEEL 2
        bonobos.stream()
                .map(CareTakerFactory::assignCareTaker)
                .filter(careTaker -> Objects.equals(careTaker.name, "Erik"))
                .map(careTaker -> careTaker.bonobo)
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .forEach(bonobo -> System.out.println(bonobo.getName()));

    }
}
