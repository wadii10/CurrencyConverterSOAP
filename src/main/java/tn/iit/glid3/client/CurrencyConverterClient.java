package tn.iit.glid3.client;

import jakarta.xml.ws.Service;
import tn.iit.glid3.service.CurrencyConverterService;


import javax.xml.namespace.QName;
import java.net.URL;
import java.security.Provider;
import java.util.List;
import java.util.Scanner;

public class CurrencyConverterClient {

    public static void main(String[] args) throws Exception {
        // WSDL URL of the SOAP service
        URL url = new URL("http://localhost:8085/CurrencyConverterSOAP/currencyconverter?wsdl");

        // QName of the service: target namespace and service name
        QName qname = new QName("http://service.glid3.iit.tn/", "CurrencyConverterServiceImplService");

        // Create the service instance
        Service service = Service.create(url, qname);

        // Get the service port (proxy to interact with the web service)
        CurrencyConverterService converter = service.getPort(CurrencyConverterService.class);

        Scanner scanner = new Scanner(System.in);

        // Step 1: Retrieve and display the list of currencies
        System.out.println("Fetching available currencies...");
        List<String> currencies = converter.getCurrencies();
        System.out.println("Available Currencies: ");
        currencies.forEach(System.out::println);

        // Step 2: Prompt user input
        System.out.print("\nEnter the amount in EUR: ");
        double amountInEUR = scanner.nextDouble();

        System.out.print("Enter the target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        // Step 3: Call the service to perform the conversion
        double convertedAmount = converter.convert(targetCurrency, amountInEUR);

        // Step 4: Display the result
        System.out.println("\nConversion Result:");
        System.out.printf("%.2f EUR = %.2f %s\n", amountInEUR, convertedAmount, targetCurrency);
    }
}


