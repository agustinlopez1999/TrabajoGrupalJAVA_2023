import Domain_classes.*;
import Reports.AccessoryReport;
import Reports.StandByPriceReport;
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
        //StandByPriceReport standsReport = new StandByPriceReport();

        //stands
        AccessoryReport report = new AccessoryReport();
        report.showReportAccessories(fair, "test.txt");

        StandByPriceReport priceReport = new StandByPriceReport();
        priceReport.showStandsByPrice(fair, "test2.txt");
    }
}
