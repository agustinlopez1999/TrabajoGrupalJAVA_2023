package Domain_classes;
//package Comparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;


import Comparator.StandPriceComparator;
import XML.*;

public class Fair {
    private TreeSet<Stand> stands;
    public Fair() {
        this.stands = new TreeSet<Stand>();
    }

    private TreeSet<Stand> getStands() {
        return stands;
    }

    public void setStands(TreeSet<Stand> stands) {
        this.stands = stands;
    }
    public void loadStandsFromXML() {
        TreeSet<Stand> loadedStands = ClassXML.loadFairXML().getStands();
        this.stands = loadedStands;
    }
    public boolean Empty(){
        return stands==null;
    }

    
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

    public void showClientStands(int _codeNumber){
        boolean flag = false;
        System.out.println("Client ["+_codeNumber+"] Stand/s:");
        for(Stand stand : stands){
            if(stand.getStandClient().getNumber() == _codeNumber){
                flag = true;
                System.out.println(stand.toString());
                System.out.println("");
            }
        }
        if(!flag)
            System.out.println("NO STANDS REGISTERED");
    }

    public void printStandsDetails() {
        for (Stand stand : stands) {
            System.out.println(stand.toString());
            System.out.println("----------------------------------------");
        }
    }

    public void showStandsByPrice(){
        ArrayList<Stand> standsByPrice = new ArrayList<>((Collection) new StandPriceComparator());
        // Agregar todos los elementos de standsByCode al nuevo TreeSet ordenado por precio
        standsByPrice.addAll(stands);
        System.out.println("STANDS BY PRICE");
        for (Stand aux : standsByPrice){
            System.out.println("code:" + aux.getCode() + " final price: "+ aux.finalValue());
        }
    }
    public void showStandsByPrice2() {
        // Crear un nuevo ArrayList e inicializarlo con los elementos del TreeSet
        ArrayList<Stand> standsByPrice = new ArrayList<>(stands);

        System.out.println("STANDS BY PRICE");
        for (Stand aux : standsByPrice) {
            System.out.println("code: " + aux.getCode() + " final price: " + aux.finalValue());
        }
    }




}
