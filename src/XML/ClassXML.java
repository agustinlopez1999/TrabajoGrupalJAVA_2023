package XML;

import Domain_classes.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.ArrayList;


public class ClassXML {

    public static Fair loadFairXML() {
        Fair fair = new Fair();
        ArrayList<Stand> stands = new ArrayList<>();
        ArrayList<String> errors = new ArrayList<>();
        try {
            // leemos el XML a traves del xml de github para evitar rutas totales.
            String url = "https://raw.githubusercontent.com/agustinlopez1999/TrabajoGrupalJAVA_2023/master/src/XML/data.xml";
            URLConnection connection = new URL(url).openConnection();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(connection.getInputStream());
            doc.getDocumentElement().normalize();

            NodeList standNodes = doc.getElementsByTagName("Stand");
            for (int i = 0; i < standNodes.getLength(); i++) {
                Node standNode = standNodes.item(i);
                if (standNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element standElement = (Element) standNode;
                    String type = getElementText(standElement, "type");
                    String code = getElementText(standElement, "code");
                    int surface = parseIntElement(standElement, "surface");
                    float m2price = parseFloatElement(standElement, "m2price");
                    int luminaries = parseIntElement(standElement, "luminaries");

                    if (type.isEmpty() || code.isEmpty() || surface <= 0 || m2price <= 0) {
                        errors.add("Error en el stand: " + code + " - Datos inválidos o incompletos.");
                        continue; // Si tiene errores, lo saltea y continua
                    }

                    NodeList accessoriesNodes = standElement.getElementsByTagName("Accessory");
                    ArrayList<Accessory> accessories = new ArrayList<>();
                    for (int j = 0; j < accessoriesNodes.getLength(); j++) {
                        Node accessoryNode = accessoriesNodes.item(j);
                        if (accessoryNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element accessoryElement = (Element) accessoryNode;
                            int id = Integer.parseInt(getElementText(accessoryElement, "id"));
                            String description = getElementText(accessoryElement, "description");
                            float price = Float.parseFloat(getElementText(accessoryElement, "price"));
                            accessories.add(new Accessory(id, description, price));
                        }
                    }

                    Element clientElement = (Element) standElement.getElementsByTagName("client").item(0);
                    int clientId = Integer.parseInt(getElementText(clientElement, "id"));
                    String name = getElementText(clientElement, "name");

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
        fair.setErrors(errors);
        fair.setStands(stands);
        return fair;
    }

    private static String getElementText(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        } else {
            return ""; // si no existe
        }
    }

    private static int parseIntElement(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            String textContent = nodeList.item(0).getTextContent();
            if (textContent != null && !textContent.isEmpty()) {
                return Integer.parseInt(textContent);
            }
        }
        return 0;
    }

    private static float parseFloatElement(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            String textContent = nodeList.item(0).getTextContent();
            if (textContent != null && !textContent.isEmpty()) {
                return Float.parseFloat(textContent);
            }
        }
        return 0.0f;
    }
}