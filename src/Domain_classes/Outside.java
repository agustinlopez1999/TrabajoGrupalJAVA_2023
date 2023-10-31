package Domain_classes;

import java.util.ArrayList;

public class Outside extends Stand {
    public Outside() {
    }

    public Outside(String code, float surface, float m2price, ArrayList<Accessory> accesories, Client standClient) {
        super(code, surface, m2price, accesories, standClient);
    }

    @Override
    public float finalValue() {
        if(getAccesoryAmount()>=3)
            return (float) (getSurface() * getM2price() + getAccesorySumPrice()* 0.9);
        else
            return getSurface() * getM2price() + getAccesorySumPrice();
    }

    

}

