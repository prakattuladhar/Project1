package com.Project1.classes;

import java.io.*;
import java.util.*;
import java.time.*;


//made singleton
public class Theater implements Serializable{
	
   private CustomerList customerList = CustomerList.instance();
   private ClientList clientList = new ClientList();
   private ShowList showList = new ShowList();

   public int[] x = new int[10];
   private static Theater theater;
   private Theater(){

   }
   public static Theater getInstance(){
       if(theater == null)
           theater = new Theater();
       return theater;
   }
   public void setTheater(Theater object){
       this.theater = object;
   }

   // Client methods
   /**
    * adds a new client
    * @param name
    * @param address
    * @param phone
    * @return true if client was added, false if client already exists
    */
   public boolean addClient(String name,String address, int phone){
	   Client client = new Client(name, address, phone);
       return clientList.add(client);

   }
   public boolean removeClient(int id){
       //true if successful
        return false;
   }
   /**
    * 
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
	   CreditCard card = new CreditCard(cardNumber, expirationDate);
	   Customer customer = new Customer(name, address, phone, card);
       return customerList.add(customer);
   }
   /**
    * Deletes a customer
    * @param id
    * @return true if customer deleted, false if no customer existed for that id
    */
   public String removeCustomer(int id) {
       Customer customer = customerList.remove(id);
       if (customer != null) {
    	   String customerInfo = customer.getId() + " " + customer.getName();
    	   return customerInfo;
       }
       return null;
   }
   /**
    * 
    * @return iterator of customers
    */
   public Iterator<Customer> getCustomerIterator(){
       return customerList.iterator();
   }
   
   // CreditCard methods
   /**
    * 
    * @param customerId
    * @param cardNumber
    * @param date
    */
   public void addCreditCard(int customerId, int cardNumber, YearMonth date) {
	   Customer customer = customerList.getCustomer(customerId);
	   if (customer == null) {
		   throw new RuntimeException("No customer exists with ID: " + customerId);
	   }
	   CreditCard card = new CreditCard(cardNumber, date);
	   customer.addCreditCard(card);
   }
   /**
    * 
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
	   } catch (RuntimeException exception) {
		   throw exception;
	   }
   }
   // Show methods
   /**
    * 
    * @param clientId
    * @param name
    * @param startDate
    * @param endDate
    * @return
    */
   public boolean addShow(int clientId, String name, LocalDate startDate, LocalDate endDate){
	   Show show = new Show(clientId, name, startDate, endDate);
       try {
    	   showList.add(show);
       } catch (ShowConflictException se) {
    	   throw se;
       } 
       return true;
   }
   /**
    * 
    * @return
    */
   public Iterator<Show> getShowIterator(){
       return showList.iterator();
   }



}
