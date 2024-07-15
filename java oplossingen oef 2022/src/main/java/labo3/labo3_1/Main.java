package labo3.labo3_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> mainCharacters = new LinkedList<String>(Arrays.asList("Daryl", "Maggie", "Michonne", "Carl",
                "Rick", "Carol", "Glenn", "Hershel", "Shane", "Negan"));
        Queue<String> newCharacters = new LinkedList<String>(Arrays.asList("Sasha", "Morgan", "Eugene", "Ezekiel"));

        Random rand = new Random(); // instance of random class
        int deaths = rand.nextInt(newCharacters.size()+1);

        System.out.println(deaths +" will be removed!!");

        for (int i = 0; i < deaths; i++) {
            System.out.println("---------------");
            int selected = rand.nextInt(mainCharacters.size());
            System.out.println("Removing: " + mainCharacters.get(selected));
            mainCharacters.remove(selected);
            String newcomer = newCharacters.poll();
            mainCharacters.add(newcomer);
            System.out.println(mainCharacters);
            System.out.println("Welcome: " +newcomer);
        }
    }
}
