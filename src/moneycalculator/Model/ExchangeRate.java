package moneycalculator.Model;

import java.util.Calendar;

public class ExchangeRate {

    
    private Currency fromCurrency;
    private Currency toCurrency;
    private Calendar date;
    private MyNumber rate;

    public ExchangeRate(Currency fromCurrency, Currency toCurrency, Calendar date, MyNumber rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
        this.rate = rate;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public Calendar getDate() {
        return date;
    }

    public MyNumber getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "fromCurrency: " + this.fromCurrency
                + " toCurrency: " + this.toCurrency
                + " date: " + this.date.get(Calendar.YEAR) + "-" + this.date.get(Calendar.MONTH) + 1 + "-" + this.date.get(Calendar.DAY_OF_MONTH)
                + " rate: " + this.rate;
    }
}