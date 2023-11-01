import Domain_classes.*;

public class Main {
    public static void main(String[] args) {
        Fair fair = new Fair();
        fair.loadStandsFromXML();

        if (fair.Empty()) {
            System.out.println("No se han cargado stands.");
        } else {
            fair.showAllStands();
        }

        //fair.showClientStands(44948204);
        fair.showStandsByPrice();
    }
}