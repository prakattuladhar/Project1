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

    //takes in cardnumber, expiration date and csv and adds credit car to customer
    public boolean addCreditcard(int cardNumber, String expDate){
    	for (CreditCard card : creditCards) {
    		if (card.getNumber() == cardNumber) {
    			return false;
    		}
    	}
    	creditCards.add( new CreditCard(cardNumber, expDate) );
    	return true;
    }
    
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
    	StringBuilder cardInformation = new StringBuilder();
    	cardInformation.append("\n\tCredit Card Info:\n");
    	for (CreditCard card : creditCards) {
    		cardInformation.append(
    			"\tCredit Card Number: " + card.getNumber() + 
    			", Expiration Date: " + card.getExpirationDate() + "\n"
    		);
    	}
    	
    	return "Customer{ " + super.toString() + cardInformation + "\n}";
    }
}
