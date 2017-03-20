package com.bst;

import java.util.HashMap;


public class CurrencyUtil {
    public static final double EUR_DEFAULT_VALUE = 4.6;
    public static final double USD_DEFAULT_VALUE = 4.3;
    private HashMap<String, Double> currency = new HashMap();

    public CurrencyUtil() {
        CurrencyYahoo cy = new CurrencyYahoo();
        setCurrency(cy.getEur(), cy.getUsd());
    }

    public Double getCurrency(String inputCurrency) {
        Double result = currency.get(inputCurrency);
        if (result != null) {
            return result;
        } else {
            // if no currency is found treat as is default currency RON
            return 1.0;
        }
    }

    private void setCurrency() {
        this.currency.put("RON", 1.0);
        this.currency.put("EUR_DEFAULT_VALUE", EUR_DEFAULT_VALUE);
        this.currency.put("USD_DEFAULT_VALUE", USD_DEFAULT_VALUE);
    }

    private void setCurrency(Double eur, Double usd) {
        if (eur!=null && usd != null){
        this.currency.put("RON", 1.0);
        this.currency.put("EUR_DEFAULT_VALUE", eur);
        this.currency.put("USD_DEFAULT_VALUE", usd);}
        else {
            setCurrency();
        }
    }

    public int getSize() {
        return this.currency.size();
    }
}
