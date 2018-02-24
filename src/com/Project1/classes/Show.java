package com.Project1.classes;

import java.util.ArrayList;

public class Show {
    private int id;
    private String name;
    private String date;
    private int clientId;
    private ArrayList<Integer> customerId=new ArrayList<Integer>();

    public Show(int id, String name, String date, int clientId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.clientId = clientId;
    }


    public void addCustomer(int id){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getClientId() {
        return clientId;
    }

    public ArrayList<Integer> getCustomerId() {
        return customerId;
    }

}
