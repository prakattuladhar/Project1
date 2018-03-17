package com.Project1.classes;

import java.io.Serializable;
import java.util.*;
import java.time.*;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int REGULAR = 1;
	public static final int ADVANCE = 2;
	public static final int STUDENT_ADVANCE = 3;
	
	protected int customerId;
	protected double price;
	protected int type;
	protected String showName;
	protected LocalDate date;
	
	public Ticket(int customerId, LocalDate date, double price, int type) {
		this.customerId = customerId;
		this.date = date;
		this.price = price;
		this.type = type;
	}
	
	// add get/set methods
}
