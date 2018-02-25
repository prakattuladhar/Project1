package com.Project1.classes;

import java.io.*;

public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;
    protected int cardNumber;
    protected String expirationDate;

    public CreditCard(int cardNumber, String expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }
    
    public int getNumber() {
    	return cardNumber;
    }
    public String getExpirationDate() {
    	return expirationDate;
    }
    
    public boolean equals(CreditCard otherCard) {
    	return this.cardNumber == otherCard.getNumber();
    }
    
    @Override
    public String toString() {
    	return "Credit Card Number: " + cardNumber + 
    			"\nExpiration Date: " + expirationDate + "\n";
    }
}
