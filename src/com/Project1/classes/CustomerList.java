package com.Project1.classes;

import java.util.*;
import java.io.*;

public class CustomerList implements Iterable<Customer>, Serializable {
	private static final long serialVersionUID = 1L;
	// allows for search, add, and remove in O(lg(n)) time
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

    public boolean add(Customer customer){
    	if ( map.containsValue(customer) ) {
    		return false;
    	}
        map.put(customer.getId(), customer);
        return true;
    }
    /**
     * 
     * @param id
     * @return customer associated with id, or null if no such customer
     */
    public Customer getCustomer(int id) {
    	return map.get(id);
    }
    /**
     * 
     * @param id
     * @return customer that was removed, or null if no such customer
     */
    public Customer remove(int id){
    	return map.remove(id);
    }
    
    public int size() {
    	return map.size();
    }
    
    public Iterator<Customer> iterator() {
    	return map.values().iterator();
    }
}
