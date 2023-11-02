package Reports;
import Domain_classes.*;
import Comparator.AccessoriesComparator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class AccessoryReport {
    AccessoriesComparator accessoriesComparator = new AccessoriesComparator();
    TreeMap<Accessory, Integer> hm = new TreeMap<Accessory, Integer>(accessoriesComparator);

    public void showReportAccessories(Fair fair, String fileName){
        TreeMap<Accessory,Integer>  tm =  fair.loadAccessories();
        int value;
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            for (Accessory aux : tm.keySet()) {
                value = tm.get(aux);
                String reportLine = aux + ": " + value;
                System.out.println(reportLine);
                fileWriter.write(reportLine + "\n");
            }
            System.out.println("Reporte de accesorios guardado en '" + fileName + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
