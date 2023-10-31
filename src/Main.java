import Domain_classes.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Fair fair = new Fair();
        fair.loadStandsFromXML();

        if (fair.getStands() == null) {
            System.out.println("No se han cargado stands.");
        } else {
            ArrayList<Stand> stands = fair.getStands();
            for (Stand stand : stands) {
                System.out.println("Stand Details:");
                System.out.println("Code: " + stand.getCode());
                System.out.println("Surface: " + stand.getSurface());
                System.out.println("M2 Price: " + stand.getM2price());

                if (stand instanceof Inside insideStand) {
                    System.out.println("Luminaries: " + insideStand.getLuminaries());
                }

                System.out.println("Accessories:");
                ArrayList<Accessory> accessories = stand.getAccesories();
                for (Accessory accessory : accessories) {
                    System.out.println("ID: " + accessory.getId());
                    System.out.println("Description: " + accessory.getDescription());
                    System.out.println("Price: " + accessory.getPrice());
                }

                Client client = stand.getStandClient();
                System.out.println("Client:");
                System.out.println("Client Number: " + client.getNumber());
                System.out.println("Client Name: " + client.getName());

                System.out.println();
            }
        }
    }
}