import Domain_classes.*;

public class Main {
    public static void main(String[] args) {
        Fair fair = new Fair();
        fair.loadStandsFromXML();
        if(fair.getStands() == null)
            System.out.println("esta nulo");
    }
}