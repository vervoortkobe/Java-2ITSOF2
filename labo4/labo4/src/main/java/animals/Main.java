package animals;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Cage<Cat> catCage = new Cage<>(5);
        catCage.addAnimal(new Cat("Pluisje", CatBreed.BENGAL, LocalDate.of(2016, 5, 12), Gender.FEMALE));
        catCage.addAnimal(new Cat("Panter", CatBreed.SIAMESE, LocalDate.of(2014, 4, 28), Gender.MALE));
        catCage.addAnimal(new Cat("Garfield", CatBreed.RAGDOLL, LocalDate.of(2017, 8, 2), Gender.MALE));
        catCage.addAnimal(new Cat("Bolleke", CatBreed.RAGDOLL, LocalDate.of(2016, 10, 8), Gender.FEMALE));

        catCage.showAnimals();

        System.out.println("************************");

        //hier jouw code
        catCage.getAnimal("oudste", Gender.MALE);
        catCage.getAnimal("jongste", Gender.FEMALE);
    }
}
