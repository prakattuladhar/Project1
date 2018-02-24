package com.Project1.classes;

public class Customer extends Member{
    private CreditCard[] creditCards=new CreditCard[5];

    public Customer(int id, String name, String address, int phone) {
        super(id, name, address, phone);
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
