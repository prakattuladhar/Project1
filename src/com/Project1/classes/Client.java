package com.Project1.classes;

import java.io.*;

public class Client extends Member implements Serializable {
	private static final long serialVersionUID = 1L;
    public Client(String name, String address, int phone) {
        super(name, address, phone);
    }

    public int getBalance() {
        return balance;
    }


    private int balance=0;

}
