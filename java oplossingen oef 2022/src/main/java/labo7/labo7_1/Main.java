package labo7.labo7_1;

import labo6.labo6_1.KeyValues;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println(names);
    }
}