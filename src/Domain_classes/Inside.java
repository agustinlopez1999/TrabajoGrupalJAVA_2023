package Domain_classes;

import java.util.ArrayList;

public class Inside extends Stand {
    private int luminaries;

    public Inside(String code, float surface, float m2price, ArrayList<Accessory> accesories, Client standClient, int luminaries) {
        super(code, surface, m2price, accesories, standClient);
        this.luminaries = luminaries;
    }

    @Override
    public float finalValue() {
        return getAccesorySumPrice()+getM2price()*getSurface()+1000*luminaries;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLuminaries: " + luminaries;
    }
}
