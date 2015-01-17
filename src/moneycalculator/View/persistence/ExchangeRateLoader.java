package moneycalculator.View.persistence;

import moneycalculator.Model.Currency;
import moneycalculator.Model.ExchangeRate;
import moneycalculator.Model.MyNumber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class ExchangeRateLoader {

    public ExchangeRate load(Calendar date, Currency from, Currency to) {
        HttpURLConnection connection = null;
        String rate = "0";
        try {
            int year = date.get(Calendar.YEAR);
            int month = date.get(Calendar.MONTH) + 1;
            int day = date.get(Calendar.DAY_OF_MONTH);
            URL url = new URL("http://currencies.apps.grandtrunk.net/getrate/" + year + "-" + month + "-" + day + "/" + from.getCode() + "/" + to.getCode());
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String linea;
            while ((linea = in.readLine()) != null) {
                rate = linea;
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }
        MyNumber n = new MyNumber(Float.parseFloat(rate));
        return new ExchangeRate(from, to, date, n);
    }
}