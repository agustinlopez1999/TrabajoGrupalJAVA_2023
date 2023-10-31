package Domain_classes;

public class Inside extends Stand {
    private int luminaries;

    public Inside(String code, float surface, float m2price, int luminaries) {
        super(code, surface, m2price);
        this.luminaries = luminaries;
    }

    @Override
    public float finalValue() {
        return getAccesorySumPrice()+getM2price()*getSurface()+1000*luminaries;
    }

    @Override
    public String toString() {
        return super.toString() + "Luminaries= "+luminaries;
    }
}
