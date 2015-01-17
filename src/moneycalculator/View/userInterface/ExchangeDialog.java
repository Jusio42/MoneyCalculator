package moneycalculator.View.userInterface;

import moneycalculator.Model.Currency;
import moneycalculator.Model.CurrencySet;
import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExchangeDialog implements CurrencyDialog {

    private Currency currency;

    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (currency == null) {
            System.out.println("Insert currency code: ");
            String code = null;
            try {
                code = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(ExchangeDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            currency = this.searchCurrency(code);
        }
    }

    private Currency searchCurrency(String code) {
        return CurrencySet.getInstance().get(code);
    }

    @Override
    public Currency getCurrency() {
        return this.currency;
    }
}