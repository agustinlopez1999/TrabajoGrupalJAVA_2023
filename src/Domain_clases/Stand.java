package Domain_clases;

public class Stand {
    private String code;
    private float surface;
    private float m2price;

    public Stand() {
    }
    public Stand(String code, float surface, float m2price) {
        this.code = code;
        this.surface = surface;
        this.m2price = m2price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public void setM2price(float m2price) {
        this.m2price = m2price;
    }

    public String getCode() {
        return code;
    }

    public float getSurface() {
        return surface;
    }

    public float getM2price() {
        return m2price;
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
