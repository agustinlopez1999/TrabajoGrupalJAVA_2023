package XML;

import Domain_classes.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ClassXML {

    public static Fair loadFairXML() {
        Fair fair = new Fair();
        ArrayList<Stand> stands = new ArrayList<>();

        try {
            File xmlFile = new File("/Users/agustinlopez/Desktop/Facultad/AYED 2 2do Cuatri/Trabajo Grupal/feria/src/XML/data.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

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

                    Stand stand;

                    if (type.equals("Inside")) {
                        stand = new Inside(code, surface, m2price, accessories, client, luminaries);
                    } else {
                        stand = new Outside(code, surface, m2price, accessories, client);
                    }

                    stands.add(stand);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            throw new RuntimeException(ex);
        }

        fair.setStands(stands);
        return fair;
    }
}