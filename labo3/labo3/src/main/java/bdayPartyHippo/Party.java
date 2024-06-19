package bdayPartyHippo;

import animalClasses.*;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class Party {
    PriorityQueue<Animal> genodigden = new PriorityQueue<>();
    public Party() {
        nodigUit(new Cat("Qianta", LocalDate.of(2018, 5, 26), Gender.FEMALE_NEUTERED, CatBreed.SIAMESE));
        nodigUit(new Dog("Max", LocalDate.of(2019, 3, 5), Gender.MALE_NEUTERED, DogBreed.Beagle));
        nodigUit(new Hippo("Hermien", LocalDate.of(2013, 8, 15), Gender.FEMALE));
        nodigUit(new Lion("Julian", LocalDate.of(2015, 6, 13), Gender.MALE));
        nodigUit(new Monkey("Boots", LocalDate.of(2016, 2, 8), Gender.MALE_NEUTERED));
    }
    void nodigUit(Animal a) {
        genodigden.add(a);
    }
}
