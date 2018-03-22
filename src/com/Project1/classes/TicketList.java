package com.Project1.classes;

import java.io.Serializable;
import java.util.*;
import java.time.*;
/**
 * @version 2.0
 * 
 * This class holds a list of tickets based on the date for which the ticket is
 * valid
 * 
 * @author Colin
 *
 */
public class TicketList implements Serializable {
	private static final long serialVersionUID = 1L;

	// Allows each date to be mapped to multiple tickets
	private TreeMap<LocalDate, ArrayList<Ticket>> map = new TreeMap<LocalDate, ArrayList<Ticket>>();
	/**
	 * Add a ticket to a specific date in the list
	 * @param ticket
	 */
	public void add(Ticket ticket) {
		ArrayList<Ticket> dateTickets = map.get( ticket.getDate() );
		// If list exists add ticket to it
		if (dateTickets != null) {
			dateTickets.add(ticket);
		}
		// If list doesn't exist, create on with ticket in it
		else {
			dateTickets = new ArrayList<Ticket>();
			dateTickets.add(ticket);
			map.put(ticket.getDate(), dateTickets);
		}
	}
	/**
	 * Gets an iterator of tickets for a particular date
	 * @param date
	 * @return Iterator<Ticket>
	 */
	public Iterator<Ticket> getTicketsByDate(LocalDate date) {
		ArrayList<Ticket> dateTickets = map.get(date);
		if (dateTickets != null) {
			return dateTickets.iterator();
		}
		else {
			return null;
		}
	}
	
}
