package zoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Bonobo> bonobos = new ArrayList<>();
        bonobos.add(new Bonobo(1, "Hortense", 1978, Gender.FEMALE));
        bonobos.add(new Bonobo(2, "Banya", 1990, Gender.FEMALE));
        bonobos.add(new Bonobo(3, "Vifijo", 1994, Gender.MALE));
        bonobos.add(new Bonobo(4, "Djanoa", 1995, Gender.FEMALE));
        bonobos.add(new Bonobo(5, "Binti", 1995, Gender.FEMALE));
        bonobos.add(new Bonobo(6, "Zamba", 1998, Gender.MALE));
        bonobos.add(new Bonobo(7, "Busira", 2004, Gender.FEMALE));
        bonobos.add(new Bonobo(8, "Kianga", 2005, Gender.FEMALE));
        bonobos.add(new Bonobo(9, "Habari", 2006, Gender.MALE));
        bonobos.add(new Bonobo(10, "Nayembi", 2006, Gender.FEMALE));
        bonobos.add(new Bonobo(11, "Moko", 2013, Gender.MALE));
        bonobos.add(new Bonobo(12, "Kikongo", 2014, Gender.MALE));
        bonobos.add(new Bonobo(13, "Bina", 2015, Gender.FEMALE));
        bonobos.add(new Bonobo(14, "Nila", 2015, Gender.FEMALE));
        bonobos.add(new Bonobo(15, "Mokonzi", 2016, Gender.MALE));
        bonobos.add(new Bonobo(16, "Sanza", 2017, Gender.FEMALE));
        bonobos.add(new Bonobo(17, "Balina", 2019, Gender.FEMALE));
        bonobos.add(new Bonobo(18, "Unabii", 2019, Gender.FEMALE));
        bonobos.add(new Bonobo(19, "Wakati", 2021, Gender.FEMALE));
        bonobos.add(new Bonobo(20, "Xolani", 2022, Gender.FEMALE));

        //Collections.sort(bonobos);
        //bonobos.sort(new BirthYearNameComparator());

        List<Bonobo> maleBonobos = new ArrayList<>();
        for (Bonobo bonobo : bonobos) if(bonobo.getGender() == Gender.MALE) maleBonobos.add(bonobo);
        //maleBonobos.sort(new IdDescComparator());
        bonobos.sort(new MotherNameComparator());
        for (Bonobo b : bonobos) System.out.println(b);
    }
}
