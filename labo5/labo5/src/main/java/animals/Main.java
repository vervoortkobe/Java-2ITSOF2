package animals;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Cage<Cat> catCage = new Cage<>(2);
        Cage<Dog> dogCage = new Cage<>(5);

        Cat cat = new Cat("Qianta", CatBreed.SIAMESE, Gender.FEMALE_NEUTERED, LocalDate.of(2023,3,15));

        catCage.addAnimal(cat);
        catCage.addAnimal(new Cat("Other cat", CatBreed.BENGAL, Gender.FEMALE, LocalDate.of(2020, 1, 1)));
        catCage.addAnimal(new Cat("Too much", CatBreed.RAGDOLL, Gender.MALE, LocalDate.of(2012, 3, 20)));
        catCage.showAnimals();
    }
}
