package com.Project1.classes;

public class CreditCard {
    protected int cardNumber;
    protected String name;
    protected String expirationDate;
    protected int csv;

    public CreditCard(int cardNumber, String name, String expirationDate, int csv) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.expirationDate = expirationDate;
        this.csv = csv;
    }
}
