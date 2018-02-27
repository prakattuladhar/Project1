package com.Project1.classes;

import java.io.*;
import java.time.*;

/**
 * @version 1.0
 * 
 * This class represents a credit card
 * 
 * @author Colin Quinn
 *
 */
public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;
    protected int cardNumber;
    protected YearMonth expirationDate;

    /**
     * Constructor
     * @param cardNumber		credit card number
     * @param expirationDate	date credit card expires
     */
    public CreditCard(int cardNumber, YearMonth expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }
    /**
     * Gets credit card number
     * @return cardNUmber		credit card number
     */
    public int getNumber() {
    	return cardNumber;
    }
    /**
     * Gets date credit card expires
     * @return expirationDate	credit card expiration date
     */
    public YearMonth getExpirationDate() {
    	return expirationDate;
    }
    /**
     * Allows comparison of cards
     * @param otherCard
     * @return true if card numbers equal, false if not
     */
    public boolean equals(CreditCard otherCard) {
    	return this.cardNumber == otherCard.getNumber();
    }
}
