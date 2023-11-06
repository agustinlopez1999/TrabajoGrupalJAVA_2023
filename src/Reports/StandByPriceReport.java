package Reports;

import Domain_classes.Fair;
import Domain_classes.Stand;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The `StandByPriceReport` class is responsible for generating and displaying a report of stands sorted by their
 * final price in ascending order. The report includes stand codes and their final prices. The report is saved to a
 * specified file.
 */
public class StandByPriceReport {
    /**
     * Generates and displays a report of stands sorted by their final price in ascending order. The report includes
     * stand codes and their final prices. The report also calculates the average price of all stands. The report is
     * saved to the specified file.
     *
     * @param fair     The `Fair` instance containing data about stands.
     * @param fileName The name of the file where the report will be saved.
     */
    public void showStandsByPrice(Fair fair, String fileName) {
        ArrayList<Stand> standsByPrice;
        int i=0;
        float sum=0;
        String reportLine;
        String reportAvarage;
        standsByPrice=fair.getSortedByPrice();
        try(FileWriter fileWriter = new FileWriter(fileName, false)){
            for (Stand aux : standsByPrice) {
                i++;
                sum+=aux.finalValue();
                reportLine = "code: " + aux.getCode() + " final price: " + aux.finalValue();
                System.out.println(reportLine);
                fileWriter.write(reportLine + "\n");
            }
            reportAvarage = "Stands average price: $"+sum/i;
            System.out.println(reportAvarage);
            fileWriter.write("\n" + reportAvarage);
            System.out.println("The report of the stands ordered by price is saved in '" + fileName + "'");
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
