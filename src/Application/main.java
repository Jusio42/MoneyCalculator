package Application;


import moneycalculator.Control.ExchangeOperation;
import moneycalculator.Model.Currency;
import moneycalculator.Model.CurrencySet;
import moneycalculator.View.persistence.CurrencySetLoader;
import moneycalculator.View.userInterface.ExchangeDialog;
import moneycalculator.View.userInterface.MoneyDisplay;
import java.io.IOException;

public class main {
    
   public static void main(String[] args) throws IOException {
        CurrencySet currencies = CurrencySet.getInstance();
        MoneyDisplay consoleMoneyDialog = new MoneyDisplay();
        ExchangeDialog consoleCurrencyDialog = new ExchangeDialog();
        ExchangeOperation control = new ExchangeOperation(currencies, consoleMoneyDialog, consoleCurrencyDialog);
        control.execute();
    }
}