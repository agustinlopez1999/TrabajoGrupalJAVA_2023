package Comparator;

import Domain_classes.Stand;
import java.util.Comparator;

public class StandPriceComparator implements Comparator<Stand>{
    @Override
    public int compare(Stand a, Stand b) {
        return Float.compare(a.finalValue(), b.finalValue());
    }
}

