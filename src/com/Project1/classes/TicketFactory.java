package com.Project1.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.math.*;
/**
 * @version 2.0
 * 
 * Implements the factory pattern to create tickets of the correct
 * type and adjusts price based on show's base ticket price
 * 
 * @author Colin Quinn
 *
 */
public class TicketFactory implements Serializable {
	private static final long serialVersionUID = 1L;
	private AtomicInteger serialNumberGenerator;
	private static TicketFactory factory;
	/**
	 * Supports Singleton Pattern
	 * Initializes Atomic Integer used to generate ticket serial numbers
	 */
	private TicketFactory() {
		serialNumberGenerator = new AtomicInteger(0);
	}
	/**
	 * Supports Singelton Pattern
	 * @return TicketFacotry
	 */
	public static TicketFactory instance() {
		if (factory == null) {
			factory = new TicketFactory();
		}
		return factory;
	}
	/**
	 * Creates tickets of appropriate type and adjusts price of ticket accordingly
	 * @param customerId
	 * @param date
	 * @param type
	 * @return
	 */
	public Ticket createTicket(int customerId, String name, LocalDate date, BigDecimal basePrice, int type) {
		
		switch (type) {
		
		case Ticket.REGULAR:
			Ticket ticket = new Ticket(serialNumberGenerator.getAndIncrement(), customerId, name, date);
			ticket.computePrice(basePrice);
			return ticket;
		case Ticket.ADVANCE:
			AdvanceTicket advanceTicket = new AdvanceTicket(serialNumberGenerator.getAndIncrement(), customerId, name, date);
			advanceTicket.computePrice(basePrice);
			return advanceTicket;
		case Ticket.STUDENT_ADVANCE:
			StudentAdvanceTicket studentAdvanceTicket = new StudentAdvanceTicket(serialNumberGenerator.getAndIncrement(), customerId, name, date);
			studentAdvanceTicket.computePrice(basePrice);
			return studentAdvanceTicket;
		default:
			return null;
		}
	}
	
	/**
     * Retrieves the factory
     * 
     * @param input inputstream for deserialization
     */
    public static void retrieve(ObjectInputStream input) {
      try {
        factory = (TicketFactory) input.readObject();
      } catch(IOException ioe) {
        ioe.printStackTrace();
      } catch(Exception cnfe) {
        cnfe.printStackTrace();
      }
    }
}
