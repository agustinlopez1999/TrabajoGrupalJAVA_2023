package Domain_classes;

import java.util.ArrayList;
/**
 * The Inside class represents a stand located inside at a fair. It extends the Stand class and calculates
 * the final value of the stand based on certain criteria.
 */
public class Inside extends Stand {
    private int luminaries;
    /**
     * Constructs an Inside stand with the specified attributes.
     *
     * @param code         The unique code for the stand.
     * @param surface      The surface area of the stand.
     * @param m2price      The price per square meter.
     * @param accessories  A list of accessories associated with the stand.
     * @param standClient  The client associated with the stand.
     * @param luminaries   The number of luminaries in the stand.
     */
    public Inside(String code, float surface, float m2price, ArrayList<Accessory> accessories, Client standClient, int luminaries) {
        super(code, surface, m2price, accessories, standClient);
        this.luminaries = luminaries;
    }
    /**
     * Gets the number of luminaries in the stand.
     *
     * @return The number of luminaries.
     */
    public int getLuminaries() {
        return luminaries;
    }
    /**
     * Sets the number of luminaries in the stand.
     *
     * @param luminaries The number of luminaries.
     */
    public void setLuminaries(int luminaries) {
        this.luminaries = luminaries;
    }
    /**
     * Calculates the final value of the Inside stand based on certain criteria.
     *
     * @return The final value of the stand.
     */
    @Override
    public float finalValue() {
        return getAccesorySumPrice()+getM2price()*getSurface()+1000*luminaries;
    }
    /**
     * Returns a string representation of the Inside stand, including luminaries.
     *
     * @return A string representation of the stand.
     */
    @Override
    public String toString() {
        return super.toString() + "Luminaries: " + luminaries;
    }
}
