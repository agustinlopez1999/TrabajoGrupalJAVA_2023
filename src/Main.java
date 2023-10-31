import Domain_classes.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Fair fair = new Fair();
        fair.loadStandsFromXML();

        if (fair.Empty()) {
            System.out.println("No se han cargado stands.");
        } else {
            fair.show();
        }
        fair.showErrors();
    }
}