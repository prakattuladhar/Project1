package com.Project1.classes;

import java.util.*;
import java.io.*;

/**
 * @version 1.0
 * 
 * This class represents a collection of customers
 * 
 * @author Colin Quinn
 *
 */
public class CustomerList implements Iterable<Customer>, Serializable {
	private static final long serialVersionUID = 1L;
	// allows for search, add, and remove in O(lg(n)) time
    private TreeMap<Integer, Customer> map = new TreeMap<Integer, Customer>();
    
    // Private field for singleton pattern
    private static CustomerList customerList;
    /**
     * Private constructor for singleton pattern
     */
    private CustomerList() {
    }
    /**
     * Supports the singleton pattern
     * @return the singleton object
     */
    public static CustomerList instance() {
    	if (customerList == null) {
    		return (customerList = new CustomerList());
    	} else {
    		return customerList;
    	}
    }
    /**
     * Adds a customer to the list
     * @param customer to be added
     */
    public boolean add(Customer customer){
        map.put(customer.getId(), customer);
        return true;
    }
    /**
     * Gets a customer associated with a ID number
     * @param id		ID number
     * @return customer associated with id, or null if no such customer
     */
    public Customer getCustomer(int id) {
    	return map.get(id);
    }
    public boolean contains(int customerId) {
    	return map.containsKey(customerId);
    }
    /**
     * Removes a customer from the list based on ID number
     * @param id		ID number of customer to be removed
     * @return customer that was removed, or null if no such customer
     */
    public Customer remove(int id){
    	return map.remove(id);
    }
    /**
     * Gets amount of customers in list
     * @return count of customers on list
     */
    public int size() {
    	return map.size();
    }
    /**
     * Gets an iterator of customers
     * return Iterator<Customer>
     */
    @Override
    public Iterator<Customer> iterator() {
    	return map.values().iterator();
    }
}
