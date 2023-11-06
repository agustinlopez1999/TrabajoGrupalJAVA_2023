package Domain_classes;

import java.util.ArrayList;
/**
 * The Outside class represents a stand located outside at a fair.
 * It extends the Stand class and calculates the final value of the stand based on certain criteria.
 */
public class Outside extends Stand {
    /**
     * Constructs an Outside stand with default values.
     */
    public Outside() {
    }
    /**
     * Constructs an Outside stand with the specified attributes.
     *
     * @param code         The unique code for the stand.
     * @param surface      The surface area of the stand.
     * @param m2price      The price per square meter.
     * @param accessories  A list of accessories associated with the stand.
     * @param standClient  The client associated with the stand.
     */
    public Outside(String code, float surface, float m2price, ArrayList<Accessory> accessories, Client standClient) {
        super(code, surface, m2price, accessories, standClient);
    }
    /**
     * Calculates the final value of the Outside stand based on certain criteria.
     *
     * @return The final value of the stand.
     */
    @Override
    public float finalValue() {
        if(getAccesoryAmount()>=3)
            return (float) (getSurface() * getM2price() + getAccesorySumPrice()* 0.9);
        else
            return getSurface() * getM2price() + getAccesorySumPrice();
    }

    

}

