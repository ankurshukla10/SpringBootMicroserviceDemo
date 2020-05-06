package com.ankur.microservices.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/****************************************************************************
 * This class ..
 *
 * @author ankurshukla
 ****************************************************************************/
@RestController
public class CurrencyConversionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
            @PathVariable BigDecimal quantity) {
        // Ooesn't have FEIGN
        // Map<String, String> uriVariables = new HashMap<>();
        // uriVariables.put("from", from);
        // uriVariables.put("to", to);
        //
        // ResponseEntity<CurrencyConversionBean> responseEntity = new
        // RestTemplate("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
        // CurrencyConversionBean.class,
        // uriVariables);

        CurrencyConversionBean response = proxy.retriveExchangeValue(from, to);
        logger.info("{}", response);
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());

    }
}
