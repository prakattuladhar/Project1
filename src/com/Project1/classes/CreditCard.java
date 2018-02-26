package com.Project1.classes;

import java.io.*;
import java.util.*;

public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;
    protected int cardNumber;
    protected Calendar expirationDate;

    public CreditCard(int cardNumber, Calendar expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }
    
    public int getNumber() {
    	return cardNumber;
    }
    public Calendar getExpirationDate() {
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
