package com.Project1.classes;

import java.io.Serializable;
import java.util.*;
import java.time.*;
import java.math.*;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int REGULAR = 1;
	public static final int ADVANCE = 2;
	public static final int STUDENT_ADVANCE = 3;
	
	protected int serialNumber;
	protected int customerId;
	protected BigDecimal price;
	protected int type;
	protected String showName;
	protected LocalDate date;
	
	public Ticket(int serialNumber, int customerId, String showName, LocalDate date) {
		this.serialNumber = serialNumber;
		this.customerId = customerId;
		this.date = date;
		this.showName = showName;
		this.type = Ticket.REGULAR;
	}
	
	// add get/set methods
	public LocalDate getDate() {
		return date;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void computePrice(BigDecimal basePrice) {
		price = basePrice.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public String toString() {
		return  "Serial Number: " + serialNumber + 
				"\nCustomer id:" + customerId +
				"\nShow Name: " + showName +
				"\nPrice: " + price;
	}
}
