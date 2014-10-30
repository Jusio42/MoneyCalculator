package Application;

import moneycalculator.Control.ExchangeOperation;
import moneycalculator.Model.CurrencySet;
import moneycalculator.View.persistence.CurrencySetLoader;

public class main {
 
    private CurrencySet currencySetLoad = new CurrencySetLoader().load();
    private ExchangeOperation exchangeOperation;
    
}
