package com.Project1.classes;

import java.util.*;
import java.io.*;

//make it singleton
public class CustomerList implements Iterable<Customer>, Serializable {
	private static final long serialVersionUID = 1L;
    private TreeMap<Integer, Customer> map = new TreeMap<Integer, Customer>();
    private static CustomerList customerList;

    private CustomerList() {
    }
    
    /**
     * Supports the singleton pattern
     * 
     * @return the singleton object
     */
    public static CustomerList instance() {
    	if (customerList == null) {
    		return (customerList = new CustomerList());
    	} else {
    		return customerList;
    	}
    }

    public void add(Customer customer){
        map.put(customer.getId(), customer);
    }
    /**
     * 
     * @param id
     * @return customer associated with id, or null if no such customer
     */
    public Customer getCustomer(int id) {
    	return map.get(id);
    }
    
    public void remove(int id){
    	map.remove(id);
    }
    
    public Iterator<Customer> iterator() {
    	return map.values().iterator();
    }
}
