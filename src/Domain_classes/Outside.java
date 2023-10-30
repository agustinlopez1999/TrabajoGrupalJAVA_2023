package Domain_classes;

public class Outside extends Stand {
    public Outside() {
    }

    public Outside(String code, float surface, float m2price) {
        super(code, surface, m2price);
    }
    @Override
    public float finalValue() {
        if(getAccesoryAmount()>=3)
            return (float) (getSurface() * getM2price() + getAccesorySumPrice()* 0.9);
        else
            return getSurface() * getM2price() + getAccesorySumPrice();
    }
}

