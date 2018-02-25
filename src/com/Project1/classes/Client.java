package com.Project1.classes;

import java.io.*;

public class Client extends Member implements Serializable {
	private static final long serialVersionUID = 1L;
	private int balance;
	
    public Client(String name, String address, int phone) {
        super(name, address, phone);
        balance = 0;
    }

    public int getBalance() {
        return balance;
    }


}
