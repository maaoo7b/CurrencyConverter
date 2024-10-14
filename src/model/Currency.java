package model;

public class Currency {

    private String codeCurrency;
    private String descriptionCurrency;

    public Currency(String codeCurrency, String descriptionCurrency) {
        this.codeCurrency = codeCurrency;
        this.descriptionCurrency = descriptionCurrency;
    }

    public String getCodeCurrency() {
        return codeCurrency;
    }

    public void setCodeCurrency(String codeCurrency) {
        this.codeCurrency = codeCurrency;
    }

    public String getDescriptionCurrency() {
        return descriptionCurrency;
    }

    public void setDescriptionCurrency(String descriptionCurrency) {
        this.descriptionCurrency = descriptionCurrency;
    }

    @Override
    public String toString() {
        return "Currency: "+
                "codeCurrency: " + codeCurrency+
                ", descriptionCurrency: " + descriptionCurrency;
    }
}
