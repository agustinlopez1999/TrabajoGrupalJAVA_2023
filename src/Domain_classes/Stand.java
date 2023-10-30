package Domain_classes;
import java.util.*;

public class Stand {
    private String code;
    private float surface;
    private float m2price;


    private ArrayList<Accessory> accesories = new ArrayList<Accessory>();


    public Stand() {
    }
    public Stand(String code, float surface, float m2price) {
        this.code = code;
        this.surface = surface;
        this.m2price = m2price;
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

    //for (String cancion : canciones) {
    //  System.out.println(cancion);
    //}
    public float getAccesorySumPrice(){
        float total = 0;
        for(Accessory aux:accesories)
            total+=aux.getPrice();
        return total;
    }

    @Override
    public String toString() {
        return "Stand{" +
                "code='" + code + '\'' +
                ", surface=" + surface +
                ", m2price=" + m2price +
                '}';
    }

}
