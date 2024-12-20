package tn.iit.glid3;

import jakarta.xml.ws.Endpoint;
import tn.iit.glid3.service.CurrencyConverterServiceImpl;

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8085/CurrencyConverterSOAP/currencyconverter", new CurrencyConverterServiceImpl());
        System.out.println("Service is published at http://localhost:8085/CurrencyConverterSOAP/currencyconverter?wsdl");
    }
}