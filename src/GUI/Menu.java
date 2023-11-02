package GUI;
import java.util.*;

public class Menu {
    public void Space(){
        System.out.println("\n");
        System.out.println("===================================================");
        System.out.println("\n");
    }
    public void showMenu(){
        Space();
        System.out.println("[ FAIR SYSTEM MAIN MENU ]\n");
        System.out.println("1- ALL Stands");
        System.out.println("2- Client Stands");
        System.out.println("3- Stands by Price");
        System.out.println("4- Accessory List");
        System.out.println("5- Exit");
    }

    public void AllStandsMenu(){
        Space();
        System.out.println("[ ALL STANDS ]\n");
    }
    public void ClientStandsMenu(){
        Space();
        System.out.println("[ CLIENT STANDS ]\n");
        System.out.println(">Type the Client Code Number: ");
    }

    public void StandsByPriceMenu(){
        Space();
        System.out.println("[ STANDS BY PRICE ]\n");
    }

    public void AccesoryListMenu(){
        Space();
        System.out.println("[ ACCESORY LIST ]\n");
    }
}
