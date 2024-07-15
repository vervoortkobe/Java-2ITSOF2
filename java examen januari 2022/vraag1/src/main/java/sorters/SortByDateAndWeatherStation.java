package sorters;

import model.Prediction;

import java.util.Comparator;

public class SortByDateAndWeatherStation implements Comparator<Prediction> {
    @Override
    public int compare(Prediction o1, Prediction o2) {
        int v = o1.getDate().compareTo(o2.getDate());
        if(v==0)
            return o1.getWeatherStation().getName().compareTo(o2.getWeatherStation().getName());
        return v;
    }
}
