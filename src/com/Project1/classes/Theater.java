package com.Project1.classes;

import java.io.*;
import java.util.*;
import java.time.*;
import java.math.*;
import com.Project1.classes.Ticket;

/**
 * 
 * @version 2.0
 * 
 * This class represents a theater with a single stage that may be rented out
 * for one show at a time.  One show may last multiple days or weeks, but on
 * any given day there may only be one show playing.
 * 
 * Shows are put on by clients who pay to rent the theater and the profits for
 * a show are split between the theater and the client financing a particular
 * show. 
 * 
 * @author Prakat Tuladhar
 *
 */
public class Theater implements Serializable {
	private static final long serialVersionUID = 1L;
	
   private CustomerList customerList = CustomerList.instance();
   private ClientList clientList = new ClientList();
   private ShowList showList = new ShowList();
   private CardNumberMap cardNumbers = new CardNumberMap();
   private TicketList ticketList = new TicketList();
   private TicketFactory ticketFactory = TicketFactory.instance();

   private static Theater theater;
   /**
    * Support singleton pattern
    */
   private Theater(){

   }
   /**
    * Gets an instance of the Theater object
    * @return theater instance
    */
   public static Theater getInstance(){
       if(theater == null)
           theater = new Theater();
       return theater;
   }
   /**
    * 
    * @param object
    */
   public void setTheater(Theater object){
       this.theater = object;
   }

   // Client methods
   /**
    * Adds a new client
    * @param name
    * @param address
    * @param phone
    * @return true if client was added, false if client already exists
    */
   public boolean addClient(String name,String address, int phone){
	   Client client = new Client(name, address, phone);
	   try {
		   return clientList.add(client);
	   } catch (RuntimeException re) {
		   throw re;
	   }
   }
   /**
    * Checks to see if client exist for given ID number
    * @param clientId
    * @return true if clientList contains client, false otherwise
    */
   public boolean hasClient(int clientId) {
	   return clientList.contains(clientId);
   }
   /**
    * Removes a client from the list of clients
    * @param id
    * @return the client that was removed
    */
   public Client removeClient(int id){
	   
       try {
    	   return clientList.remove(id, showList);
       } catch (RuntimeException re) {
    	   throw re;
       }
   }
   /**
    * Gets an iterator for all clients in the theater
    * @return iterator of clients
    */
   public Iterator<Client> getClientIterator(){
       return clientList.iterator();
   }
   
   // Customer methods
    /**
     * Adds a new customer
     * @param name
     * @param address
     * @param phone
     * @param cardNumber
     * @param expirationDate
     * @return true if customer added, false if customer already exists
     */
   public boolean addCustomer(String name, String address, int phone, int cardNumber, YearMonth expirationDate){
	   if ( cardNumbers.containsCard(cardNumber) ) {
		   throw new RuntimeException("Add failed: Credit card " + cardNumber + "already exists");
	   }
	   CreditCard card = new CreditCard(cardNumber, expirationDate);
	   Customer customer = new Customer(name, address, phone, card);
	   cardNumbers.addCard(cardNumber, card);
       return customerList.add(customer);
   }
   /**
    * Checks to see if customer exists for given ID number
    * @param customerId
    * @return true if list contains customer, false otherwise
    */
   public boolean hasCustomer(int customerId) {
	   return customerList.contains(customerId);
   }
   /**
    * Deletes a customer
    * @param id
    * @return true if customer deleted, false if no customer existed for that id
    */
   public String removeCustomer(int id) {
       Customer customer = customerList.remove(id);
       if (customer != null) {
    	   Iterator<CreditCard> cardIterator = customer.getCreditCardIterator();
    	   while ( cardIterator.hasNext() ) {
    		   CreditCard card = cardIterator.next();
    		   cardNumbers.removeCard( card.getNumber() );
    	   }
    	   String customerInfo = customer.getId() + " " + customer.getName();
    	   return customerInfo;
       }
       return null;
   }
   /**
    * Gets an iterator for the list of all customers
    * @return iterator of customers
    */
   public Iterator<Customer> getCustomerIterator(){
       return customerList.iterator();
   }
   
   // CreditCard methods
   /**
    * Adds a credit card associated with a particular customer
    * @param customerId
    * @param cardNumber
    * @param date
    */
   public void addCreditCard(int customerId, int cardNumber, YearMonth date) {
	   Customer customer = customerList.getCustomer(customerId);
	   if (customer == null) {
		   throw new RuntimeException("No customer exists with ID: " + customerId);
	   }
	   if ( cardNumbers.containsCard(cardNumber) ) {
		   throw new RuntimeException("Add failed: Credit card " + cardNumber + " already exists");
	   }
	   CreditCard card = new CreditCard(cardNumber, date);
	   customer.addCreditCard(card);
	   cardNumbers.addCard(cardNumber, card);
   }
   /**
    * Deletes a credit card for a particular customer
    * Customers must of have at least one credit card,
    * so this method will not delete a credit card if
    * it is the customer's only credit card
    * @param customerId
    * @param cardNumber
    */
   public void removeCreditCard(int customerId, int cardNumber) {
	   Customer customer = customerList.getCustomer(customerId);
	   if (customer == null) {
		   throw new RuntimeException("No customer exists with ID: " + customerId);
	   }
	   try {
		   customer.removeCreditCard(cardNumber);
		   cardNumbers.removeCard(cardNumber);
	   } catch (RuntimeException exception) {
		   throw exception;
	   }
   }
   // Show methods
   /**
    * Adds a show to the calendar of shows.
    * Show dates my not overlap, and each
    * show must be associated wit a specific
    * client
    * @param clientId
    * @param name
    * @param startDate
    * @param endDate
    * @return true if show added, false otherwise
    */
   public boolean addShow(int clientId, String name, LocalDate startDate, LocalDate endDate, BigDecimal ticketPrice){
	   if ( !clientList.contains(clientId) ) {
		   throw new RuntimeException("Client ID: " + clientId + " does not exist");
	   }
	   Show show = new Show(clientId, name, startDate, endDate, ticketPrice);
       try {
    	   showList.add(show);
       } catch (ShowConflictException se) {
    	   throw se;
       }
       return true;
   }
   /**
    * Gets an iterator for all shows on the calendar
    * @return iterator<Show>
    */
   public Iterator<Show> getShowIterator(){
       return showList.iterator();
   }

   /**
    * 
    * @param ticketType
    * @param quant
    * @param cusNum
    * @param cardNum
    * @param date
    * @throws Exception
    */
   public void addTicket(int ticketType, int quant, int cusNum, int cardNum, LocalDate date) throws Exception {

       //check if cardNumber and  exists before this function can return anything
	   Customer customer = customerList.getCustomer(cusNum);
	   if (customer == null) {
		   throw new Exception("Customer ID: " + cusNum + " does not exist");
	   }
        if( !customer.hasCreditCard(cardNum) ){
            throw new Exception("Customer does not have credit card number: " + cardNum);
        }
        
        Show show = showList.getShowByDate(date);
        if (show == null) {
        	throw new Exception("No show on this date");
        }
        BigDecimal basePrice = show.getBaseTicketPrice();

        for(int i = 0;i < quant; i++) {
        	Ticket ticket = ticketFactory.createTicket(cusNum, date, basePrice, Ticket.REGULAR);
        	ticketList.add(ticket);
        }
   }


   //should return array of ticket list
    public Iterator<Ticket> getTicketList(LocalDate date) {
        return ticketList.getTicketsByDate(date);
    }

    //takes in client number and amount and pay the client. Throws exception if client not found or balance amount is greater than balance
    public void payClient(int clientNumber, int amount) throws Exception {
       if(false){
           throw new Exception("Not found");
       }
       Client client = clientList.getClient(clientNumber);
       client.payBalance(amount);
    }
    public int getClientBalance(int clientNumber) {
    	return clientList.getClient(clientNumber).getBalance();
    }
}
