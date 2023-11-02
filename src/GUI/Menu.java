package GUI;

/**
 * The Menu class provides methods to display various menus for the Fair System.
 */
public class Menu {

    /**
     * Displays space for separation in the console.
     */
    public void Space() {
        System.out.println("\n");
        System.out.println("===================================================");
        System.out.println("\n");
    }

    /**
     * Displays the main menu of the Fair System.
     */
    public void showMenu() {
        Space();
        System.out.println("[ FAIR SYSTEM MAIN MENU ]\n");
        System.out.println("1- ALL Stands");
        System.out.println("2- Client Stands");
        System.out.println("3- Stands by Price");
        System.out.println("4- Accessory List");
        System.out.println("5- Exit");
    }

    /**
     * Displays the menu for showing all stands.
     */
    public void AllStandsMenu() {
        Space();
        System.out.println("[ ALL STANDS ]\n");
    }

    /**
     * Displays the menu for showing client stands.
     */
    public void ClientStandsMenu() {
        Space();
        System.out.println("[ CLIENT STANDS ]\n");
        System.out.println(">Type the Client Code Number: ");
    }

    /**
     * Displays the menu for showing stands by price.
     */
    public void StandsByPriceMenu() {
        Space();
        System.out.println("[ STANDS BY PRICE ]\n");
    }

    /**
     * Displays the menu for showing the accessory list.
     */
    public void AccesoryListMenu() {
        Space();
        System.out.println("[ ACCESSORY LIST ]\n");
    }
}
