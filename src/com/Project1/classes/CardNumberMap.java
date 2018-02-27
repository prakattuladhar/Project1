package com.Project1.classes;

import java.util.*;
import java.io.*;

/**
 * @version 1.0
 * 
 * This class is used to prevent multiple credit cards from existing
 * 
 * @author Colin Quinn
 *
 */
public class CardNumberMap implements Serializable {
	private static final long serialVersionUID = 1L;
	private TreeMap<Integer, CreditCard> map = new TreeMap<Integer, CreditCard>();
	/**
	 * Adds a card to the card map
	 * @param cardNumber
	 * @param card
	 */
	public void addCard(int cardNumber, CreditCard card) {
		map.put(cardNumber, card);
	}
	/**
	 * checks to see if card is in cardmap
	 * @param cardNumber
	 * @return true if in map, false if not
	 */
	public boolean containsCard(int cardNumber) {
		return map.containsKey(cardNumber);
	}
	/**
	 * removes credit card and number from map
	 * @param cardNumber
	 * @return card removed
	 */
	public CreditCard removeCard(int cardNumber) {
		return map.remove(cardNumber);
	}
	
}
