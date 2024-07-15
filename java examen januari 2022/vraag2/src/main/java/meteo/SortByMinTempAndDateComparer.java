package meteo;

import java.util.Comparator;

public class SortByMinTempAndDateComparer implements Comparator<Temperature> {
    @Override
    public int compare(Temperature o1, Temperature o2) {
        double v = o1.getMin() - o2.getMin();
        if(v == 0)
            return o2.getDate().compareTo(o1.getDate());
        if(v < 0)
            return -1;
        return +1;
    }
}
