package zoo;

import java.util.Comparator;

public class MotherNameComparator implements Comparator<Bonobo> {
    @Override
    public int compare(Bonobo o1, Bonobo o2) {
        if(o1.getMother() == null && o2.getMother() == null) return 0;
        else if(o1.getMother() == null) return -1;
        else if(o2.getMother() == null) return 1;
        return o1.getMother().compareTo(o2.getMother());
    }
}
