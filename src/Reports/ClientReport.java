package Reports;
import Domain_classes.*;
import java.util.TreeSet;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The `ClientReport` class is responsible for generating and displaying a report of stands associated with a
 * specific client identified by a code number. The report is saved to a specified file.
 */
public class ClientReport {
    /**
     * Generates and displays a report of stands associated with a specific client identified by the provided code number.
     * The report is saved to the specified file.
     *
     * @param _codeNumber The code number of the client for whom the report is generated.
     * @param fair        The `Fair` instance containing data about stands and clients.
     * @param fileName    The name of the file where the report will be saved.
     */
    public void showClientStands(int _codeNumber, Fair fair, String fileName){
        TreeSet<Stand> aux = new TreeSet<>();
        String reportCode;
        String reportNoStands;
        try (FileWriter fileWriter = new FileWriter(fileName, false)){
            reportCode = "Client ["+_codeNumber+"] Stand/s:";
            System.out.println(reportCode);
            fileWriter.write(reportCode);
            aux = fair.getClientStands(aux,_codeNumber);
            if(aux.isEmpty()){
                reportNoStands = "\nClient doesn't have any Stands \n";
                System.out.println(reportNoStands);
                fileWriter.write(reportNoStands);
            }
            else{
                for(Stand stand:aux){
                    System.out.println(stand+"\n");
                    fileWriter.write(stand+"\n");
                }
            }
            System.out.println("Client report saved in '" + fileName + "'");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
