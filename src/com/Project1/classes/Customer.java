package com.Project1.classes;

import java.io.*;

public class Customer extends Member implements Serializable {
	private static final long serialVersionUID = 1L;
    private CreditCard[] creditCards = new CreditCard[5];

    public Customer(String name, String address, int phone) {
        super(name, address, phone);
    }


    //takes in cardnumber, expiration date and csv and adds credit car to customer
    public void addCreditcard(int cardNumber,String expDate,int csv){

    }
    public void removeCreditcard(int cardNumber){

    }
    public CreditCard[] getCreditCards() {
        return creditCards;
    }
}
