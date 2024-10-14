package model;

import java.util.Date;

public class CurrencyHistorial {
    private String baseCurrency;
    private String targetCurrency;
    private Date date;
    private double currencyAmount;
    private double currencyConversion;

    public CurrencyHistorial(String baseCurrency, String targetCurrency, Date date, double currencyAmount, double currencyConversion) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.date = date;
        this.currencyAmount = currencyAmount;
        this.currencyConversion = currencyConversion;
    }
    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(double currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public double getCurrencyConversion() {
        return currencyConversion;
    }

    public void setCurrencyConversion(double currencyConversion) {
        this.currencyConversion = currencyConversion;
    }

    @Override
    public String toString() {
        return "CurrencyHistorial{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", date=" + date +
                ", currencyAmount=" + currencyAmount +
                ", currencyConversion=" + currencyConversion +
                '}';
    }
}
