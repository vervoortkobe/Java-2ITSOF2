package animals;

import java.time.LocalDate;
import animalClasses.*;

public class Main {
    public static void main(String[] args) {

        Cage<Cat> catCage = new Cage<>();
        Cage<Dog> dogCage = new Cage<>();
        Cat cat = new Cat("Qianta", LocalDate.of(2018, 5, 26), Gender.FEMALE_NEUTERED, CatBreed.SIAMESE);

        if (catCage.addAnimal(cat)) System.out.println("cat added");
        else System.out.println("list is full");
        catCage.showAnimals();
    }
}