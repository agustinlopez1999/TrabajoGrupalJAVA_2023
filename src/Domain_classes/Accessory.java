package Domain_classes;

public class Accessory {
    private int id;
    private String description;
    private float price;
    public Accessory(int id, String description, float price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "id =" + id +
                ", description ='" + description + '\'' +
                ", price =" + price +
                '}';
    }
}
