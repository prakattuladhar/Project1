package com.Project1.classes;

import java.io.*;
import java.math.*;

/**
 * @version 1.0
 * 
 * Represents a theater client.  Clients are individuals who rent the theater
 * to put on shows.
 * 
 * @author Colin Quinn
 *
 */
public class Client extends Member implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal balance;
	/**
	 * Constructor
	 * @param name		name of client
	 * @param address	client's address
	 * @param phone		client's phone number
	 */
    public Client(String name, String address, int phone) {
        super(name, address, phone);
        balance = new BigDecimal("0.00");
    }
    /**
     * Gets balance on client's account
     * @return balance
     */
    public BigDecimal getBalance() {
        return balance;
    }
    public void updateBalance(BigDecimal revenue){
        balance = balance.add(revenue).setScale(2, RoundingMode.HALF_UP);
    }
    public void payBalance(BigDecimal amount){
        balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }
}
