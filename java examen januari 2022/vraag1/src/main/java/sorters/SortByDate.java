package sorters;

import model.Prediction;

import java.util.Comparator;

public class SortByDate implements Comparator<Prediction> {
    @Override
    public int compare(Prediction o1, Prediction o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
