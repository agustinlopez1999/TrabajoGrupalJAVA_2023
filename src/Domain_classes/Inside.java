package Domain_classes;

public class Inside extends Stand {
    private int luminaries;

    @Override
    public float finalValue() {
        return getAccesorySumPrice()+getM2price()*getSurface()+1000*luminaries;
    }
}
