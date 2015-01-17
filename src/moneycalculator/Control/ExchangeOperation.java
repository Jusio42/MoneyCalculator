package moneycalculator.Control;


import java.io.IOException;
import java.util.Calendar;
import moneycalculator.Model.CurrencySet;
import moneycalculator.Model.Exchange;
import moneycalculator.Model.ExchangeRate;
import moneycalculator.View.userInterface.ExchangeDialog;
import moneycalculator.View.userInterface.MoneyDisplay;
import moneycalculator.View.userInterface.MoneyViewer;
import moneycalculator.View.persistence.CurrencySetLoader;
import moneycalculator.View.persistence.ExchangeRateLoader;

public class ExchangeOperation {

    private final CurrencySet currencySet;
    private final MoneyDisplay consoleMoneyDialog;
    private final ExchangeDialog consoleCurrencyDialog;
    private final Exchange moneyExchanger;
    private ExchangeRate exchangeRate;

    public ExchangeOperation(CurrencySet currencySet, MoneyDisplay consoleMoneyDialog, ExchangeDialog consoleCurrencyDialog) {
        this.currencySet = currencySet;
        this.consoleMoneyDialog = consoleMoneyDialog;
        this.moneyExchanger = new Exchange();
        this.consoleCurrencyDialog = consoleCurrencyDialog;
    }

    public void execute() throws IOException {
        loadCurrencySet(currencySet);
        consoleMoneyDialog.execute();
        consoleCurrencyDialog.execute();
        exchangeRate = loadExchangeRate();
        doMoneyExchange();
        show();
    }

    private void loadCurrencySet(CurrencySet currencySet) {
        CurrencySetLoader currencySetLoader = new CurrencySetLoader();
        CurrencySetLoader.load(currencySet);
    }

    private ExchangeRate loadExchangeRate() {
        ExchangeRateLoader exchangeRateLoader = new ExchangeRateLoader();
        return exchangeRateLoader.load(Calendar.getInstance(), consoleMoneyDialog.getMoney().getCurrency(), consoleCurrencyDialog.getCurrency());
    }

    private void doMoneyExchange() {
        moneyExchanger.exchange(consoleMoneyDialog.getMoney(), exchangeRate);
    }

    private void show() {
        MoneyViewer moneyViewer = new MoneyViewer();
        moneyViewer.show(moneyExchanger.getMoney());
    }



}