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
        standsByPrice=fair.GetSortedByPrice();
        try(FileWriter fileWriter = new FileWriter(fileName, false)){
            for (Stand aux : standsByPrice) {
                i++;
                sum+=aux.finalValue();
                System.out.println("code: " + aux.getCode() + " final price: " + aux.finalValue());
                fileWriter.write("code: " + aux.getCode() + " final price: " + aux.finalValue() + "\n");
            }
            System.out.println("Stands average price: $"+sum/i);
            fileWriter.write("\nStands average price: $"+sum/i);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
