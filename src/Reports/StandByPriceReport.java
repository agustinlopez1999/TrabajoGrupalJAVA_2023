package Reports;

import Comparator.StandPriceComparator;
import Domain_classes.Fair;
import Domain_classes.Stand;

import java.util.ArrayList;

public class StandByPriceReport {
    public StandByPriceReport() {

    }
    public void showStandsByPrice(Fair fair) {
        ArrayList<Stand> standsByPrice;
        int i=0;
        float sum=0;
        standsByPrice=fair.GetSortedByPrice();
        System.out.println("STANDS BY PRICE");
        for (Stand aux : standsByPrice) {
            i++;
            sum+=aux.finalValue();
            System.out.println("code: " + aux.getCode() + " final price: " + aux.finalValue());
        }
        System.out.println("Stands average price: $"+sum/i);
    }
}
