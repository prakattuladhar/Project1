package com.Project1.classes;

import java.io.*;
import java.util.*;

/**
 * @version 1.0
 * 
 * This class represents a customer
 * 
 * @author Colin Quinn
 *
 */
public class Customer extends Member implements Serializable {
	private static final long serialVersionUID = 1L;
    private ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>(5);
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>(5);
    /**
     * Constructor
     * @param name		name of customer
     * @param address	customer's address
     * @param phone		customer's phone number
     * @param card		customer's credit card
     */
    public Customer(String name, String address, int phone, CreditCard card) {
        super(name, address, phone);
        creditCards.add(card);
    }
    /**
     * Adds a credit card associated with customer
     * @param:cardNumber	credit card number
     * @param:expDate		credit card expiration date
     * @return true if credit card added, false if credit card already exists
     */
    public boolean addCreditCard(CreditCard card){
    	creditCards.add(card);
    	return true;
    }
    /**
     * See if customer has card with specific card number
     * @param cardNumber
     * @return true if customer has credit card with same number, false if not
     */
    public boolean hasCreditCard(int cardNumber) {
    	for(CreditCard card : creditCards) {
    		if (card.getNumber() == cardNumber) {
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * Removes a credit card associated with customer
     * If customer only has one card, it may not be removed
     * @param cardNumber	number of credit card to be deleted
     * @RuntimeException	on attempt to delete last card
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
     * Gets number of credit cards associated with customer
     * @return count of credit cards customer owns
     */
    public int getCreditCardCount() {
    	return creditCards.size();
    }
    /**
     * Gets an iterator for the customer's credit cards
     * @return iterator<CreditCard>
     */
    public Iterator<CreditCard> getCreditCardIterator() {
        return creditCards.iterator();
    }
    /**
     * String representation of customer's fields and credit cards
     */
    public void addTicket(Ticket ticket) {
    	tickets.add(ticket);
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
