package zoo;

import java.util.Comparator;

public class IdDescComparator implements Comparator<Bonobo> {
    @Override
    public int compare(Bonobo o1, Bonobo o2) {
        if(o1.getId() < o2.getId()) return 1;
        else if (o1.getId() > o2.getId()) return -1;
        else return 0;
    }
}