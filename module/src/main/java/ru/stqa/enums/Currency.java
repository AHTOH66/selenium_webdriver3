package ru.stqa.enums;

public enum Currency {

    USD("US Dollars"),
    EUR("Euros");

    private final String currency;
    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
