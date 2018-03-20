package com.Project1.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class StudentAdvanceTicket extends Ticket{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor
	 * @param serialNumber
	 * @param customerId
	 * @param showName
	 * @param date
	 */
	public StudentAdvanceTicket(int serialNumber, int customerId, String showName, LocalDate date) {
		super(serialNumber, customerId, showName, date);
		this.type = Ticket.STUDENT_ADVANCE;
	}
	/**
	 * Price becomes %50 of price of regular ticket
	 */
	@Override
	public void computePrice(BigDecimal basePrice) {
		price = basePrice.multiply( new BigDecimal("50.0") ).divide( new BigDecimal("100.0"), 2, RoundingMode.HALF_UP );
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n*Student Advance Ticket";
	}
}
