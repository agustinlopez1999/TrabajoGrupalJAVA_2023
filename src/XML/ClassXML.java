package XML;

import Domain_classes.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class ClassXML {

    public static Fair loadFairXML() {
        try {
            File xmlFile = new File("path/to/your/xml/fair.xml"); // Reemplazar con la ruta real del archivo XML

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            Fair fair = new Fair();
            ArrayList<Stand> stands = new ArrayList<>();

            NodeList standNodes = doc.getElementsByTagName("Stand");
            for (int i = 0; i < standNodes.getLength(); i++) {
                Node standNode = standNodes.item(i);
                if (standNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element standElement = (Element) standNode;
                    String type = standElement.getElementsByTagName("type").item(0).getTextContent();
                    String code = standElement.getElementsByTagName("code").item(0).getTextContent();
                    int surface = Integer.parseInt(standElement.getElementsByTagName("surface").item(0).getTextContent());
                    float m2price = Float.parseFloat(standElement.getElementsByTagName("m2price").item(0).getTextContent());
                    int luminaries = Integer.parseInt(standElement.getElementsByTagName("luminaries").item(0).getTextContent());

                    NodeList accessoriesNodes = standElement.getElementsByTagName("Accessory");
                    ArrayList<Accessory> accessories = new ArrayList<>();
                    for (int j = 0; j < accessoriesNodes.getLength(); j++) {
                        Node accessoryNode = accessoriesNodes.item(j);
                        if (accessoryNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element accessoryElement = (Element) accessoryNode;
                            int id = Integer.parseInt(accessoryElement.getElementsByTagName("id").item(0).getTextContent());
                            String description = accessoryElement.getElementsByTagName("description").item(0).getTextContent();
                            float price = Float.parseFloat(accessoryElement.getElementsByTagName("price").item(0).getTextContent());
                            accessories.add(new Accessory(id, description, price));
                        }
                    }

                    Element clientElement = (Element) standElement.getElementsByTagName("client").item(0);
                    int clientId = Integer.parseInt(clientElement.getElementsByTagName("id").item(0).getTextContent());
                    String name = clientElement.getElementsByTagName("name").item(0).getTextContent();

                    Client client = new Client(clientId, name);
                    if(type.equals("Inside"))
                        Stand stand = new Inside(code, surface, m2price, luminaries, accessories, client);
                    stands.add(stand);
                }
            }

            fair.setStands(stands);
            return fair;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Fair();
    }
}
