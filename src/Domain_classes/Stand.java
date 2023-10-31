package Domain_classes;
import java.util.*;

public class Stand {
    private String code;
    private float surface;
    private float m2price;

    private ArrayList<Accessory> accesories = new ArrayList<Accessory>();

    private Client standClient;

    public Stand() {
    }

    public Stand(String code, float surface, float m2price, ArrayList<Accessory> accesories, Client standClient) {
        this.code = code;
        this.surface = surface;
        this.m2price = m2price;
        this.accesories = accesories;
        this.standClient = standClient;
    }

    //setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public void setM2price(float m2price) {
        this.m2price = m2price;
    }

    //getters
    public String getCode() {
        return code;
    }

    public float getSurface() {
        return surface;
    }

    public float getM2price() {
        return m2price;
    }

    public float finalValue(){
        return 0;
    }

    public void addAccessory(Accessory _accesory){
        accesories.add(_accesory);
    }


    public float getAccesorySumPrice(){
        float total = 0;
        for(Accessory aux:accesories)
            total+=aux.getPrice();
        return total;
    }

    public int getAccesoryAmount(){
        int total = 0;
        for(Accessory aux:accesories)
            total++;
        return total;
    }

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

}
