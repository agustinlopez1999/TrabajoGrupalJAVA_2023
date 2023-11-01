package Reports;
import Domain_classes.*;
import Comparator.AccessoriesComparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AccessoryReport {
    AccessoriesComparator accessoriesComparator = new AccessoriesComparator();
    TreeMap<Accessory, Integer> hm = new TreeMap<Accessory, Integer>(accessoriesComparator);

    public void showReportAccessories(Fair fair){
        TreeMap<Accessory,Integer>  tm =  fair.loadAccessories();
        int value;
        for (Accessory aux : tm.keySet()){
            value = tm.get(aux);
            System.out.println(aux + ": " + value);
        }
    }

}
