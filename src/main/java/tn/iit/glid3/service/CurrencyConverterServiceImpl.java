package tn.iit.glid3.service;

import jakarta.jws.WebService;
import tn.iit.glid3.CurrencyParser;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebService(endpointInterface = "tn.iit.glid3.service.CurrencyConverterService")
public class CurrencyConverterServiceImpl implements CurrencyConverterService {
    private final Map<String, Double> currencyRates;

    public CurrencyConverterServiceImpl() {
        CurrencyParser parser = new CurrencyParser();
        this.currencyRates = parser.parseCurrencyRates("src/main/resources/eurofxref-daily.xml");
    }

    @Override
    public List<String> getCurrencies() {
        return new ArrayList<>(currencyRates.keySet());
    }

    @Override
    public double convert(String currency, double amount) {
        return amount * currencyRates.getOrDefault(currency, 0.0);
    }
}
