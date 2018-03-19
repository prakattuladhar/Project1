package com.Project1.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.math.*;

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
	public Ticket createTicket(int customerId, LocalDate date, BigDecimal basePrice, int type) {
		BigDecimal price = null;
		
		switch (type) {
		
		// add logic to get correct price instead of 0 for each type of ticket
		case Ticket.REGULAR:
			return new Ticket(serialNumberGenerator.getAndIncrement(), customerId, date, basePrice, Ticket.REGULAR);
		case Ticket.ADVANCE:
			// decimal accurate rounding of: price = basePrice * 70 / 100
			price = basePrice.multiply( new BigDecimal(70.0) ).divide( new BigDecimal(100.0), 2, RoundingMode.HALF_UP);
			return new Ticket(serialNumberGenerator.getAndIncrement(), customerId, date, price, Ticket.ADVANCE);
		case Ticket.STUDENT_ADVANCE:
			// decimal accurate rounding of: price = basePrice * 50 / 100
			price = basePrice.multiply( new BigDecimal(50.0) ).divide( new BigDecimal(100.0), 2, RoundingMode.HALF_UP);
			return new Ticket(serialNumberGenerator.getAndIncrement(), customerId, date, price, Ticket.STUDENT_ADVANCE);
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
