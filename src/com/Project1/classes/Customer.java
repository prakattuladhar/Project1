package com.Project1.classes;

import java.io.*;
import java.util.*;

public class Customer extends Member implements Serializable {
	private static final long serialVersionUID = 1L;
    private ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>(5);

    public Customer(String name, String address, int phone, CreditCard card) {
        super(name, address, phone);
        creditCards.add(card);
    }
    /**
     * adds a credit card associated with customer
     * @param cardNumber
     * @param expDate
     * @return true if credit card added, false if credit card already exists
     */
    public boolean addCreditCard(int cardNumber, String expDate){
    	for (CreditCard card : creditCards) {
    		if (card.getNumber() == cardNumber) {
    			return false;
    		}
    	}
    	creditCards.add( new CreditCard(cardNumber, expDate) );
    	return true;
    }
    /**
     * removes a credit card associated with customer
     * @param cardNumber
     * @return
     */
    public boolean removeCreditcard(int cardNumber){
    	int i = 0;
    	for (CreditCard card : creditCards) {
    		if (card.getNumber() == cardNumber) {
    			creditCards.remove(i);
    			return true;
    		}
    		i++;
    	}
    	return false;
    }
    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }
    
    @Override
    public String toString() {
    	// Formats credit card information
    	StringBuilder cardInformation = new StringBuilder();
    	cardInformation.append("\n\tCredit Card Info:\n");
    	for (CreditCard card : creditCards) {
    		cardInformation.append(card);
    	}
    	
    	return "Customer{ " + super.toString() + cardInformation + "\n}";
    }
}
