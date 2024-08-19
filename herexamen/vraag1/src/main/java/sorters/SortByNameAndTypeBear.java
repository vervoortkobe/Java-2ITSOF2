package sorters;

import entity.Locatie;

import java.util.Comparator;

public class SortByNameAndTypeBear implements Comparator<Locatie> {
    @Override
    public int compare(Locatie o1, Locatie o2) {
        int v = o1.getNaam().compareTo(o2.getNaam());
        if(v==0)
            return o1.getType().compareTo(o2.getType());
        return v;
    }
}
