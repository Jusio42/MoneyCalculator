package moneycalculator.Model;


public class MyNumber {

    private float numerator;
    private float denominator;

    public MyNumber(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public MyNumber(float numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public MyNumber(MyNumber number) {
        numerator = number.getNumerator();
        denominator = number.getDenominator();
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setNumerator(float numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(float denominator) {
        this.denominator = denominator;
    }

    public MyNumber add(MyNumber number) {
        MyNumber result = new MyNumber(0, 0);
        result.setDenominator(this.denominator * number.getDenominator());
        result.setNumerator((this.numerator * number.getDenominator()) + (number.getNumerator() * this.denominator));
        return result;
    }

    public MyNumber mult(MyNumber number) {
        MyNumber result = new MyNumber(0, 0);
        result.setNumerator(this.numerator * number.getNumerator());
        result.setDenominator(this.denominator * number.getDenominator());
        return result;
    }

    public MyNumber sub(MyNumber number) {
        MyNumber result = new MyNumber(0, 0);
        result.setDenominator(this.denominator * number.getDenominator());
        result.setNumerator((this.numerator * number.getDenominator()) - (number.getNumerator() * this.denominator));
        return result;
    }

    
    public MyNumber div(MyNumber number) {
        MyNumber result = new MyNumber(0, 0);
        result.setDenominator(this.denominator * number.getNumerator());
        result.setNumerator((this.numerator * number.getDenominator()));
        return result;
    }

    @Override
    public String toString() {
        return Float.toString(this.numerator);
    }
}