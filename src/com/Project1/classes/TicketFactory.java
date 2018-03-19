package com.Project1.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketFactory implements Serializable {
	private static final long serialVersionUID = 1L;
	private AtomicInteger serialNumberGenerator;
	private static TicketFactory factory;
	/**
	 * Initializes Atomic Integer used to generate ticket serial numbers
	 */
	private TicketFactory() {
		serialNumberGenerator = new AtomicInteger(0);
	}
	/**
	 * 
	 * @return
	 */
	public static TicketFactory instance() {
		if (factory == null) {
			factory = new TicketFactory();
		}
		return factory;
	}
	/**
	 * 
	 * @param customerId
	 * @param date
	 * @param type
	 * @return
	 */
	public Ticket createTicket(int customerId, LocalDate date, int type) {
		switch (type) {
		
		// add logic to get correct price instead of 0 for each type of ticket
		case Ticket.REGULAR:
			return new Ticket(serialNumberGenerator.getAndIncrement(), customerId, date, 0, Ticket.REGULAR);
		case Ticket.ADVANCE:
			return new Ticket(serialNumberGenerator.getAndIncrement(), customerId, date, 0, Ticket.ADVANCE);
		case Ticket.STUDENT_ADVANCE:
			return new Ticket(serialNumberGenerator.getAndIncrement(), customerId, date, 0, Ticket.STUDENT_ADVANCE);
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
