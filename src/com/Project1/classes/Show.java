package com.Project1.classes;

import java.io.Serializable;
import java.util.*;
import java.time.*;

/**
 * @version 1.0
 * 
 * This class represents a show or play that is performed at the theater
 * 
 * @author Colin Quinn
 *
 */
public class Show implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int clientId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    // holds ids of customers attending show
    private ArrayList<Integer> customerIds = new ArrayList<Integer>();
    
    /**
     * Constructor
     * @param clientId		ID of client sponsoring the show
     * @param name			name of the show
     * @param startDate		first date of show run
     * @param endDate		last date of show run
     */
    public Show(int clientId, String name, LocalDate startDate, LocalDate endDate) {   	
    	this.clientId = clientId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    /**
     * Gets ID of client sponsoring show
     * @return clientId
     */
    public int getClientId() {
        return clientId;
    }
    /**
     * Gets name of client
     * @return name		client name
     */
    public String getName() {
        return name;
    }
    /**
     * Returns date show starts
     * @return start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }
    /**
     * Gets date show ends
     * @return end date
     */
    public LocalDate getEndDate() {
    	return endDate;
    }
    /**
     * Gets ArrayList of customer ids of show attendants
     * @return customerIds
     */
    public ArrayList<Integer> getCustomerIds() {
        return customerIds;
    }
}
