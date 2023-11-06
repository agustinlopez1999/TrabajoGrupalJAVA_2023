package Domain_classes;

/**
 * The Accessory class represents an accessory that can be associated with a stand.
 * It includes attributes such as an ID, description, and price.
 */
public class Accessory {
    private final int id;
    private String description;
    private float price;

    /**
     * Constructs an Accessory object with the specified ID, description, and price.
     *
     * @param id          The unique identifier for the accessory.
     * @param description The description of the accessory.
     * @param price       The price of the accessory.
     */
    public Accessory(int id, String description, float price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    /**
     * Retrieves the ID of the accessory.
     *
     * @return The ID of the accessory.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the description of the accessory.
     *
     * @return The description of the accessory.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the accessory.
     *
     * @param description The new description of the accessory.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the price of the accessory.
     *
     * @return The price of the accessory.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the accessory.
     *
     * @param price The new price of the accessory.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the Accessory object.
     *
     * @return A string containing the ID, description, and price of the accessory.
     */
    @Override
    public String toString() {
        return "Accessory{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
