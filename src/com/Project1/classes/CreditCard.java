package com.Project1.classes;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;
    protected int cardNumber;
    protected YearMonth expirationDate;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");

    public CreditCard(int cardNumber, YearMonth expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }
    
    public int getNumber() {
    	return cardNumber;
    }
    public YearMonth getExpirationDate() {
    	return expirationDate;
    }
    
    public boolean equals(CreditCard otherCard) {
    	return this.cardNumber == otherCard.getNumber();
    }
    
    @Override
    public String toString() {
    	return "Credit Card Number: " + cardNumber + 
    			"\nExpiration Date: " + expirationDate.format(formatter) + "\n";
    }
}
