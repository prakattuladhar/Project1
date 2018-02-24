package com.Project1.classes;

public class Client extends Member{
    public Client(int id,String name, String address, int phone) {
        super(id,name,address,phone);
    }

    public int getBalance() {
        return balance;
    }


    private int balance=0;

}
