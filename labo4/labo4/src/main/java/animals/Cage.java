package animals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cage<T extends Animal> {
    private final int maxAnimals;
    private final List<T> animals = new ArrayList<>();

    public Cage(int maxAnimals) {
        this.maxAnimals = maxAnimals;
    }

    public boolean addAnimal(T animal) {
        if (animals.size() >= maxAnimals) {
            return false;
        } else {
            animals.add(animal);
            return true;
        }
    }

    public void showAnimals() {
        for (T animal : animals) {
            System.out.println(animal.toString());
        }
    }

    public T getAnimal(String leeftijd, Gender gender) {
        switch (leeftijd) {
            case "oudste":
                {
                    List<T> oudste = animals.stream()
                            .filter(animal -> animal.getGender() == gender)
                            .sorted(Comparator.comparing(Animal::getDateOfBirth))
                            .findFirst().stream().collect(Collectors.toList());
                    System.out.println(oudste);
                    break;
                }
            case "jongste":
                {
                    List<T> jongste = animals.stream()
                            .filter(animal -> animal.getGender() == gender)
                            .sorted((o1, o2) -> o2.getDateOfBirth().compareTo(o1.getDateOfBirth()))
                            .findFirst()
                            .stream().collect(Collectors.toList());
                    System.out.println(jongste);
                    break;
                }
            default:
                break;
        }
        return null;
    }
}
