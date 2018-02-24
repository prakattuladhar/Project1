package com.Project1.classes;

import java.util.ArrayList;

//make it singleton
public class CustomerList {
    private ArrayList<Customer> list=new ArrayList<Customer>();

    public ArrayList<Customer> getList(){
        return list;
    }

    public void append(Customer customer){
        list.add(customer);
    }
    public void remove(int id){

    }
}
