package Domain_classes;

import java.util.ArrayList;
import XML.*;

public class Fair {
    private ArrayList<Stand> stands;

    public Fair() {
        this.stands = new ArrayList<>();
    }

    private ArrayList<Stand> getStands() {
        return stands;
    }

    public void setStands(ArrayList<Stand> stands) {
        this.stands = stands;
    }

    public void loadStandsFromXML() {
        ArrayList<Stand> loadedStands = ClassXML.loadFairXML().getStands();
        this.stands = loadedStands;
    }
    public boolean Empty(){
        return stands==null;
    }
    public void show(){
        for (Stand stand : stands){
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

    public void printStandsDetails() {
        for (Stand stand : stands) {
            System.out.println(stand.toString());
            System.out.println("----------------------------------------");
        }
    }
}
