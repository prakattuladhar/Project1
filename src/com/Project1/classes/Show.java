package com.Project1.classes;

import java.io.Serializable;
import java.util.*;
import java.time.*;

public class Show implements Serializable {
    private int clientId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Integer> customerIds = new ArrayList<Integer>();

    public Show(int clientId, String name, LocalDate startDate, LocalDate endDate) {   	
    	this.clientId = clientId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        
    }
    
    public int getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    
    public LocalDate getEndDate() {
    	return endDate;
    }

    public ArrayList<Integer> getCustomerIds() {
        return customerIds;
    }

}
