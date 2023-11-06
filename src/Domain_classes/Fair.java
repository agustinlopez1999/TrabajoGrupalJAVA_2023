package Domain_classes;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import Comparator.AccessoriesComparator;
import Comparator.StandPriceComparator;
import XML.*;


/**
 * The Fair class represents a fair that includes a collection of stands.
 * It provides various methods for managing and displaying information about the stands.
 */

public class Fair{
    private TreeSet<Stand> stands;

    /**
     * Constructs a Fair object with an empty collection of stands.
     */
    public Fair() {
        this.stands = new TreeSet<>();
    }
    /**
     * Retrieves stands associated with a specific client.
     *
     * @param aux         A TreeSet to store the client's stands.
     * @param _codeNumber The client number.
     * @return A TreeSet of stands associated with the client.
     */
    public TreeSet<Stand> getClientStands(TreeSet<Stand> aux, int _codeNumber){
        for(Stand stand: stands){
            if(stand.getStandClient().getNumber() == _codeNumber)
                aux.add(stand);
        }
        return aux;
    }
    /**
     * Retrieves an ArrayList of stands sorted by price.
     *
     * @return An ArrayList of stands sorted by price.
     */
    public ArrayList<Stand> getSortedByPrice(){
        StandPriceComparator priceComparator = new StandPriceComparator();
        ArrayList<Stand> aux = new ArrayList<>(stands);
        aux.sort(priceComparator);
        return aux;
    }
    /**
     * Retrieves the collection of stands.
     *
     * @return The collection of stands.
     */
    private TreeSet<Stand> getStands() {
        return stands;
    }

    /**
     * Sets the collection of stands.
     *
     * @param stands The new collection of stands.
     */
    public void setStands(TreeSet<Stand> stands) {
        this.stands = stands;
    }
    /**
     * Loads stands from an XML source.
     */
    public void loadStandsFromXML() {
        this.stands = ClassXML.loadFairXML().getStands();
    }
    /**
     * Displays details of all stands in the fair.
     */
    public void showAllStands(){
        for (Stand stand : stands){
            System.out.println("\t(Stand Details:)");
            System.out.println("Code: " + stand.getCode());
            System.out.println("Surface: " + stand.getSurface());
            System.out.println("M2 Price: " + stand.getM2price());

            if (stand instanceof Inside insideStand) {
                System.out.println("Luminaries: " + insideStand.getLuminaries());
            }

            System.out.println("Accessories:");
            ArrayList<Accessory> accessories = stand.getAccesories();
            for (Accessory accessory : accessories) {
                System.out.println("{");
                System.out.println("ID: " + accessory.getId());
                System.out.println("Description: " + accessory.getDescription());
                System.out.println("Price: " + accessory.getPrice());
                System.out.println("}");
            }

            Client client = stand.getStandClient();
            System.out.println("Client:");
            System.out.println("Client Number: " + client.getNumber());
            System.out.println("Client Name: " + client.getName());
            System.out.println();
        }
    }
    /**
     * Loads accessories and their counts into a TreeMap.
     *
     * @return A TreeMap containing accessories and their counts.
     */
    public TreeMap loadAccessories(){
        AccessoriesComparator accessoriesComparator = new AccessoriesComparator();
        TreeMap<Accessory, Integer> tMap = new TreeMap<>(accessoriesComparator);
        Integer count;
        for (Stand stand: stands) {
            for (Accessory accessory : stand.getAccesories()) {
                count = tMap.get(accessory);
                if (count == null)
                    tMap.put(accessory, 1);
                else
                    tMap.put(accessory, count + 1);
            }
        }
        return tMap;
    }

}
