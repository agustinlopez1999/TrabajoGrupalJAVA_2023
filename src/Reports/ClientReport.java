package Reports;

import Domain_classes.*;
import java.util.TreeSet;
import java.io.FileWriter;
import java.io.IOException;

public class ClientReport {
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
