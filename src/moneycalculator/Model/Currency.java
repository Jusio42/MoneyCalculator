package moneycalculator.Model;

public class Currency {
  
    private final String code;
    private final String symbol;
    private final String name;

    public Currency(String code, String symbol, String name) {
        this.code = code;
        this.symbol = symbol;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
     @Override
    public String toString() {
        return this.code;
    }
    
}