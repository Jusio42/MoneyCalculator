package moneycalculator.View.persistence;

import moneycalculator.Model.Currency;
import moneycalculator.Model.CurrencySet;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencySetLoader {

    public static void load(CurrencySet currencySet) {
        DataBaseHandler db = new DataBaseHandler();
        ResultSet resultado = null;
        String sql = "select code, name, symbol from currencies";
        try {
            resultado = db.consultar(sql);
            if (resultado != null) {
                while (resultado.next()) {
                    String code, name, symbol;
                    code = resultado.getObject(1).toString();
                    name = resultado.getObject(2).toString();
                    symbol = resultado.getObject(3).toString();
                    currencySet.add(new Currency(code, name, symbol));
                }
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}