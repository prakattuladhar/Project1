package com.Project1.classes;

import java.io.*;

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
	private int balance;
	/**
	 * Constructor
	 * @param name		name of client
	 * @param address	client's address
	 * @param phone		client's phone number
	 */
    public Client(String name, String address, int phone) {
        super(name, address, phone);
        balance = 0;
    }
    /**
     * Gets balance on client's account
     * @return balance
     */
    public int getBalance() {
        return balance;
    }
}
