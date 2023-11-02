import Domain_classes.*;
import GUI.Menu;
import Reports.AccessoryReport;
import Reports.ClientReport;
import Reports.StandByPriceReport;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0, _codeNumber;
        Menu menu = new Menu();
        Fair fair = new Fair();
        ClientReport client_report = new ClientReport();
        StandByPriceReport priceReport = new StandByPriceReport();
        AccessoryReport report = new AccessoryReport();
        fair.loadStandsFromXML();
        do {
            menu.showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    menu.AllStandsMenu();
                    fair.showAllStands();
                    break;
                case 2:
                    menu.ClientStandsMenu();
                    _codeNumber = scanner.nextInt();
                    scanner.nextLine();
                    client_report.showClientStands(_codeNumber, fair, "./src/Reports/ClientStands_Report.txt");
                    break;
                case 3:
                    menu.StandsByPriceMenu();
                    priceReport.showStandsByPrice(fair, "./src/Reports/StandPrice_Report.txt");
                    break;
                case 4:
                    menu.AccesoryListMenu();
                    report.showReportAccessories(fair, "./src/Reports/Accesories_Report.txt");
                    break;
                case 5:
                    System.out.println("Closing session...");
                    break;
                default:
                    System.out.println("[ INVALID OPTION! ]");
                    break;
            }
        } while (option != 5);
        scanner.close();
    }
}
