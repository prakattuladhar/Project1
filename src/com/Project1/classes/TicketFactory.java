package com.Project1.classes;

import java.io.Serializable;
import java.time.*;

public class TicketFactory implements Serializable{
	private static TicketFactory factory;
	
	private TicketFactory() {
	}
	
	public static TicketFactory instance() {
		if (factory == null) {
			factory = new TicketFactory();
		}
		return factory;
	}
	
	public Ticket createTicket(int customerId, LocalDate date, int type) {
		switch (type) {
		
		// add logic to get correct price instead of 0 for each type of ticket
		case Ticket.REGULAR:
			return new Ticket(customerId, date, 0, Ticket.REGULAR);
		case Ticket.ADVANCE:
			return new Ticket(customerId, date, 0, Ticket.ADVANCE);
		case Ticket.STUDENT_ADVANCE:
			return new Ticket(customerId, date, 0, Ticket.STUDENT_ADVANCE);
		default:
			return null;
		}
	}
}
