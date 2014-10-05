package moneycalculator;

import java.util.Date;

public class Exchange {
    private final Date date;
    private final Money money;
    private final Currency currency;

    public Exchange(Date date, Money money, Currency currency) {
        this.date = date;
        this.money = money;
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public Money getMoney() {
        return money;
    }

    public Currency getCurrency() {
        return currency;
    }
    
}
