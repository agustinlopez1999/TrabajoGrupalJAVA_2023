package Comparator;

import Domain_classes.Accessory;
import Domain_classes.Stand;
import java.util.Comparator;

public class AccessoriesComparator implements Comparator<Accessory>{
    @Override
    public int compare(Accessory a, Accessory b) {
        return a.getDescription().compareTo(b.getDescription());
    }
}