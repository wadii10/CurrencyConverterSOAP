package tn.iit.glid3;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CurrencyParser {
    public Map<String, Double> parseCurrencyRates(String filePath) {
        Map<String, Double> currencyRates = new HashMap<>();
        try {
            File file = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Cube");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.hasAttribute("currency") && element.hasAttribute("rate")) {
                        String currency = element.getAttribute("currency");
                        Double rate = Double.parseDouble(element.getAttribute("rate"));
                        currencyRates.put(currency, rate);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencyRates;
    }
}

