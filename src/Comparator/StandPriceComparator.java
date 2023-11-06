package Comparator;

import Domain_classes.Stand;
import java.util.Comparator;

/**
 * This class implements a comparator for objects of the {@link Stand} class.
 * It compares two stands based on their final values using floating-point comparison.
 */
public class StandPriceComparator implements Comparator<Stand> {
    /**
     * Compares two {@link Stand} objects based on their final values.
     *
     * @param a The first {@link Stand} object to compare.
     * @param b The second {@link Stand} object to compare.
     * @return A negative value if 'a' is less than 'b', a positive value if 'a' is greater than 'b',
     *         or zero if they have the same final value.
     */
    @Override
    public int compare(Stand a, Stand b) {
        return Float.compare(a.finalValue(), b.finalValue());
    }
}

