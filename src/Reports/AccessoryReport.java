package Reports;
import Domain_classes.*;
import Comparator.AccessoriesComparator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * The `AccessoryReport` class is responsible for generating and displaying an accessories report based on the data
 * provided by a `Fair` instance. The report includes the count of each accessory type and is saved to a specified file.
 */
public class AccessoryReport {
    AccessoriesComparator accessoriesComparator = new AccessoriesComparator();
    TreeMap<Accessory, Integer> hm = new TreeMap<Accessory, Integer>(accessoriesComparator);
    /**
     * Generates and displays an accessories report based on the data provided by a `Fair` instance.
     * The report includes the count of each accessory type and is saved to a specified file.
     *
     * @param fair     The `Fair` instance containing data about stands and accessories.
     * @param fileName The name of the file where the report will be saved.
     */
    public void showReportAccessories(Fair fair, String fileName){
        TreeMap<Accessory,Integer>  tm =  fair.loadAccessories();
        int value;
        String reportLine;
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            for (Accessory aux : tm.keySet()) {
                value = tm.get(aux);
                reportLine = aux + ": " + value;
                System.out.println(reportLine);
                fileWriter.write(reportLine + "\n");
            }
            System.out.println("Accessories report saved in '" + fileName + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
