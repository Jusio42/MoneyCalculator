package moneycalculator.UI;


import moneycalculator.Model.Currency;

public class CurrencyViewer {

    public void show(Currency currency) {
        System.out.println(currency.getCode());
    }
}