package Domain_classes;
import java.util.*;
/**
 * The `Stand` class represents an exhibition stand with specific attributes.
 * Each stand is associated with a unique code, a surface area, a price per square meter, a list of accessories,
 * and a client. This class implements the `Comparable` interface to allow sorting based on the stand's code.
 */
public class Stand implements Comparable<Stand>{
    /**
     * The unique code for the stand.
     */
    private String code;
    /**
     * The surface area of the stand in square meters.
     */
    private float surface;
    /**
     * The price per square meter for the stand.
     */
    private float m2price;
    /**
     * A list of accessories associated with the stand.
     */
    private ArrayList<Accessory> accesories = new ArrayList<>();
    /**
     * The client associated with the stand.
     */
    private Client standClient;
    /**
     * Constructs a new empty `Stand`.
     */
    public Stand() {
    }
    /**
     * Constructs a Stand with the specified attributes.
     *
     * @param code         The unique code for the stand.
     * @param surface      The surface area of the stand.
     * @param m2price      The price per square meter.
     * @param accessories  A list of accessories associated with the stand.
     * @param standClient  The client associated with the stand.
     */
    public Stand(String code, float surface, float m2price, ArrayList<Accessory> accessories, Client standClient) {
        this.code = code;
        this.surface = surface;
        this.m2price = m2price;
        this.accesories = accessories;
        this.standClient = standClient;
    }
    /**
     * Retrieves the client associated with the stand.
     *
     * @return The client associated with the stand.
     */
    public Client getStandClient() {
        return standClient;
    }
    /**
     * Calculates and returns the total price of all accessories associated with the stand.
     *
     * @return The total price of accessories.
     */
    public float getAccesorySumPrice(){
        float total = 0;
        for(Accessory aux:accesories)
            total+=aux.getPrice();
        return total;
    }
    /**
     * Retrieves the number of accessories associated with the stand.
     *
     * @return The number of accessories.
     */
    public int getAccesoryAmount(){
        int total = 0;
        for(Accessory aux:accesories)
            total++;
        return total;
    }

    /**
     * Retrieves the code of the stand.
     *
     * @return The unique code of the stand.
     */
    public String getCode() {
        return code;
    }

    /**
     * Retrieves the surface of the stand.
     *
     * @return The surface the stand.
     */
    public float getSurface() {
        return surface;
    }

    /**
     * Retrieves meters square price of the stand.
     *
     * @return The meters square price of the stand.
     */
    public float getM2price() {
        return m2price;
    }
    /**
     * Sets the code of the stand.
     *
     * @param code The unique code for the stand.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Sets the surface of the stand.
     *
     * @param surface The surface area of the stand.
     */
    public void setSurface(float surface) {
        this.surface = surface;
    }

    /**
     * Sets the meters square price of the stand.
     *
     * @param m2price The price per square meter.
     */
    public void setM2price(float m2price) {
        this.m2price = m2price;
    }
    /**
     * Calculates and returns the final value of the stand.
     * The final value depends on the stand type (Inside or Outside) and accessories.
     *
     * @return The final value of the stand.
     */
    public float finalValue(){
        return 0;
    }
    /**
     * Adds an accessory to the list of accessories for this stand.
     *
     * @param _accessory The accessory to be added.
     */
    public void addAccessory(Accessory _accessory){
        accesories.add(_accessory);
    }
    /**
     * Retrieves the list of accessories associated with the stand.
     *
     * @return The list of accessories.
     */
    public ArrayList<Accessory> getAccesories() {
        return accesories;
    }

    /**
     * Generates a string representation of the stand's details.
     *
     * @return A string containing the stand's details.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stand details:\n");
        sb.append("Code: ").append(code).append("\n");
        sb.append("Surface: ").append(surface).append("\n");
        sb.append("Price per m²: ").append(m2price).append("\n");

        sb.append("Accessories:\n");
        for (Accessory accessory : accesories) {
            sb.append("ID: ").append(accessory.getId()).append(", Description: ").append(accessory.getDescription()).append(", Price: ").append(accessory.getPrice()).append("\n");
        }

        sb.append("Client details:\n");
        sb.append("Client ID: ").append(standClient.getNumber()).append(", Name: ").append(standClient.getName()).append("\n");

        return sb.toString();
    }
    /**
     * Compares this stand to another stand based on their unique codes.
     *
     * @param auxStand The stand to compare to.
     * @return A negative value if this stand's code is less, zero if equal, or a positive value if greater.
     */
    @Override
    public int compareTo(Stand auxStand) {
        return this.code.compareTo(auxStand.code);
    }
}
