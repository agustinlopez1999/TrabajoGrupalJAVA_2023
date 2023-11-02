package Reports;

import Domain_classes.*;
import java.util.TreeSet;
import java.io.FileWriter;
import java.io.IOException;

public class ClientReport {
    public void showClientStands(int _codeNumber, Fair fair, String fileName){
        TreeSet<Stand> aux = new TreeSet<>();
        try (FileWriter fileWriter = new FileWriter(fileName, false)){
            System.out.println("Client ["+_codeNumber+"] Stand/s:");
            fileWriter.write("Client ["+_codeNumber+"] Stand/s:"); //TRATAR DE NO REPETIR CODIGO
            aux = fair.getClientStands(aux,_codeNumber);
            if(aux.isEmpty()){
                System.out.println("\nClient doesn't have any Stands");
                fileWriter.write("\nClient doesn't have any Stands");
            }
            else{
                for(Stand stand:aux){
                    System.out.println(stand+"\n");
                    fileWriter.write(stand+"\n");
                }
            }
            System.out.println("Reporte de Cliente guardado en '" + fileName + "'");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
