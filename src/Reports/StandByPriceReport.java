package Reports;

import Comparator.StandPriceComparator;
import Domain_classes.Fair;
import Domain_classes.Stand;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StandByPriceReport {
    public void showStandsByPrice(Fair fair, String fileName) {
        ArrayList<Stand> standsByPrice;
        int i=0;
        float sum=0;
        String reportLine;
        String reportAvarage;
        standsByPrice=fair.GetSortedByPrice();
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
