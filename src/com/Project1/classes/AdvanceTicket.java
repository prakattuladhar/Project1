package com.Project1.classes;

import java.time.LocalDate;
import java.math.*;
/**
 * @version 2.0
 * 
 * This class represents an advance ticket.
 * Advance tickets are cheaper but must be bought a day
 * in advance
 * 
 * @author Colin Quinn
 *
 */
public class AdvanceTicket extends Ticket {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor
	 * @param serialNumber
	 * @param customerId
	 * @param showName
	 * @param date
	 */
	public AdvanceTicket(int serialNumber, int customerId, String showName, LocalDate date) {
		super(serialNumber, customerId, showName, date);
		this.type = Ticket.ADVANCE;
	}
	/**
	 * Price becomes 70% price of regular ticket
	 */
	@Override
	public void computePrice(BigDecimal basePrice) {
		price = basePrice.multiply( new BigDecimal("70.0") ).divide( new BigDecimal("100.0"), 2, RoundingMode.HALF_UP );
	}
	/**
	 * String representation of advance ticket
	 */
	@Override
	public String toString() {
		return super.toString() + "\n*Advance Ticket";
	}
}
