
package moneycalculator.Model;

import java.util.HashSet;
import java.util.Set;


public class CurrencySet {
    
    private final Set<Currency> currencySet;

    public CurrencySet() {
        this.currencySet = new HashSet<>();
    }

    public Set<Currency> getCurrencySet() {
        return currencySet;
    }
    
}
