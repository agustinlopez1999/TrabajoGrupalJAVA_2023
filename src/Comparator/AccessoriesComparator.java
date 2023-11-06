package Comparator;

import Domain_classes.Accessory;
import java.util.Comparator;

/**
 * This class implements a comparator for objects of the {@link Accessory} class.
 * It compares two accessories based on their descriptions in lexicographical order.
 */
public class AccessoriesComparator implements Comparator<Accessory> {
    /**
     * Compares two {@link Accessory} objects based on their descriptions.
     *
     * @param a The first {@link Accessory} object to compare.
     * @param b The second {@link Accessory} object to compare.
     * @return A negative value if 'a' is less than 'b', a positive value if 'a' is greater than 'b',
     *         or zero if they are equal.
     */
    @Override
    public int compare(Accessory a, Accessory b) {
        return a.getDescription().compareTo(b.getDescription());
    }
}
