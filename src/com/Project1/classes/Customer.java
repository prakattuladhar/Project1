package com.Project1.classes;

import java.io.*;
import java.util.*;

public class Customer extends Member implements Serializable {
	private static final long serialVersionUID = 1L;
    private ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>(5);
    /**
     * 
     * @param name
     * @param address
     * @param phone
     * @param card
     */
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
    public boolean addCreditCard(CreditCard card){
    	creditCards.add(card);
    	return true;
    }
    /**
     * removes a credit card associated with customer
     * if customer only has one card, it may not be removed
     * @param cardNumber
     * @RuntimeException if try to delete last card
     */
    public void removeCreditCard (int cardNumber){
    	if (creditCards.size() <= 1) {
    		String message = "Remove failed: Customer must have at least one credit card";
    		throw new RuntimeException(message);
    	}
    	int i = 0;
    	for (CreditCard card : creditCards) {
    		if (card.getNumber() == cardNumber) {
    			creditCards.remove(i);
    			return;
    		}
    		i++;
    	}
    	throw new RuntimeException("Credit card " + cardNumber +
    			" not on file for customer");
    }
    /**
     * 
     * @return
     */
    public int getCreditCardCount() {
    	return creditCards.size();
    }
    /**
     * 
     * @return
     */
    public Iterator<CreditCard> getCreditCardIterator() {
        return creditCards.iterator();
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
