package com.Project1.classes;

public class CreditCard {
    protected int cardNumber;
    protected String name;
    protected String expirationDate;


    public CreditCard(int cardNumber, String name, String expirationDate) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.expirationDate = expirationDate;
    }
}
