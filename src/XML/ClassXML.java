package XML;

import Domain_classes.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * The `ClassXML` class is responsible for loading fair data from an XML source, processing the XML content,
 * and populating a `Fair` object with the relevant data. Additionally, it handles error checking and reporting.
 */
public class ClassXML {
    /**
     * Loads fair data from an XML source and populates a `Fair` object with the parsed data.
     *
     * @return A `Fair` object containing stands and associated data.
     * @throws RuntimeException If an error occurs during XML parsing or if data is missing or invalid.
     */
    public static Fair loadFairXML() {
        Fair fair = new Fair();
        TreeSet<Stand> stands = new TreeSet<>();
        ArrayList<String> errors = new ArrayList<>();
        try {
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
                    String code = getElementText(standElement, "code").toUpperCase();
                    int surface = parseIntElement(standElement, "surface");
                    float m2price = parseFloatElement(standElement, "m2price");
                    int luminaries = parseIntElement(standElement, "luminaries");

                    if(code.isEmpty() || type.isEmpty()|| surface <=0 || m2price <=0 && (type.equals("Inside") && luminaries<0)) {
                        if (code.isEmpty()) {
                            errors.add("The stand doesn't have a code");
                            code = "NULL"; // ?
                        }
                        if (type.isEmpty())
                            errors.add("The stand with the: " + code + " doesn´t have a type or is invalid");
                        if (surface <= 0) //si esta vacio?
                            errors.add("The stand with the code " + code + " has a invalid value to surface");
                        if (m2price <= 0)
                            errors.add("The stand with the code " + code + " has a invalid value to square meters price");
                        if (type.equals("Inside")) {
                            if(luminaries < 0)
                                errors.add("The Inside stand with the code " + code + " has a invalid value to luminaries");
                        }
                        continue;
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
                        stand = new Inside(code, surface, m2price, accessories, client, luminaries); // luminarias puede ser vacio.
                    } else {
                        stand = new Outside(code, surface, m2price, accessories, client);
                    }

                    if(!stands.add(stand)){
                        errors.add("Stand Code ["+code+"] already exists.");
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            throw new RuntimeException(ex);
        }
        for(String error: errors){
            System.out.println(error);
        }
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
    /**
     * Parses the text content of an XML element and converts it to an integer.
     *
     * @param element  The XML element containing the text content to be parsed.
     * @param tagName  The name of the XML tag to retrieve the content from.
     * @return An integer value parsed from the XML element, or 0 if no valid content is found.
     */
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
    /**
     * Parses the text content of an XML element and converts it to a floating-point number.
     *
     * @param element  The XML element containing the text content to be parsed.
     * @param tagName  The name of the XML tag to retrieve the content from.
     * @return A float value parsed from the XML element, or 0.0f if no valid content is found.
     */
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