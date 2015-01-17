package moneycalculator.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class CurrencySet extends HashSet<Currency> {

    private static CurrencySet instance = null;

    private CurrencySet() {
        super();
    }

    public static CurrencySet getInstance() {
        if (instance == null) {
            instance = new CurrencySet();
        }
        return instance;
    }

    public Currency get(String code) {
        for (Currency currency : this) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return currency;
            }
        }
        return null;
    }

    public Currency[] search(String token) {
        ArrayList<Currency> list = new ArrayList<Currency>();
        for (Currency currency : this) {
            if (currency.getCode().equalsIgnoreCase(token)) {
                list.add(currency);
            } else if (currency.getSymbol().equalsIgnoreCase(token)) {
                list.add(currency);
            } else if (currency.getName().toLowerCase().contains(token.toLowerCase())) {
                list.add(currency);
            }
        }
        Currency[] currency = new Currency[(list.size())];
        return list.toArray(currency);
    }
}