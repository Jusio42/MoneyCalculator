package moneycalculator.Model;

import java.util.Date;


public class Exchange {

    private Money money;

    public void exchange(Money money, ExchangeRate exchangeRate) {
        this.money = new Money(money.getAmount().mult(exchangeRate.getRate()), exchangeRate.getToCurrency());
    }

    public Money getMoney() {
        return money;
    }
}