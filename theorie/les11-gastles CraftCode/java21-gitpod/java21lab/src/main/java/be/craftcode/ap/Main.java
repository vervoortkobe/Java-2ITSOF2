package be.craftcode.ap;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StringTemplate.RAW;

public class Main {
    public static void main(String[] args) {
        var world = "world";
        StringTemplate template = RAW."hello \{world}";
        System.out.println(template.fragments());
        System.out.println(template.values());
        System.out.println(StringTemplate.interpolate(template.fragments(), List.of()));
    }
}