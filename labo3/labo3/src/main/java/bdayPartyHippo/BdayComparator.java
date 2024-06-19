package bdayPartyHippo;

import animalClasses.Animal;

import java.time.LocalDate;
import java.util.Comparator;

public class BdayComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        if(o1.getName() == "Hermien") return 1;
        else if(o2.getName() == "Hermien") return 1;
        else {
            int result = Integer.parseInt(o1.getAge()) - Integer.parseInt(o2.getAge());
            if (result == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return result;
        }
    }
}
