package tn.iit.glid3.service;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface CurrencyConverterService {
    @WebMethod
    List<String> getCurrencies();

    @WebMethod
    double convert(String currency, double amount);
}
