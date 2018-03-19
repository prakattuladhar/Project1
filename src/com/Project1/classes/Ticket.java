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
	
	public Ticket(int serialNumber, int customerId, LocalDate date, BigDecimal price, int type) {
		this.serialNumber = serialNumber;
		this.customerId = customerId;
		this.date = date;
		this.price = price;
		this.type = type;
	}
	
	// add get/set methods
	public LocalDate getDate() {
		return date;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Customer id:" + customerId + "\nType:" + type + "Price:" + price;
	}
}
