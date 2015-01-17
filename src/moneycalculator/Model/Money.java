package moneycalculator.Model;

public class Money {

    
    private final MyNumber amount;
    private final Currency currency;

    public Money(MyNumber amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public MyNumber getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "" + amount;
    }
}