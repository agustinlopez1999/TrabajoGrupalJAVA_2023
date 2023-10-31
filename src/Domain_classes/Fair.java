package Domain_classes;

import java.util.ArrayList;
import XML.*;

public class Fair {
    private ArrayList<Stand> stands;

    public Fair() {
        this.stands = new ArrayList<>();
    }

    public ArrayList<Stand> getStands() {
        return stands;
    }

    public void setStands(ArrayList<Stand> stands) {
        this.stands = stands;
    }

    public void loadStandsFromXML() {
        ArrayList<Stand> loadedStands = ClassXML.loadFairXML().getStands();
        this.stands = loadedStands;
    }

    public void printStandsDetails() {
        for (Stand stand : stands) {
            System.out.println(stand.toString());
            System.out.println("----------------------------------------");
        }
    }
}
