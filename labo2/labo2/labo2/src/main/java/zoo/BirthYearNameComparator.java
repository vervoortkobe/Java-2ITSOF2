package zoo;

import java.util.Comparator;

public class BirthYearNameComparator implements Comparator<Bonobo> {
    @Override
    public int compare(Bonobo o1, Bonobo o2) {
        int result = o1.getYearOfBirth() - o2.getYearOfBirth();
        if(result == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return result;
    }
}
