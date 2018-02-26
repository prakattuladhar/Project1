package com.Project1.classes;

import java.io.*;
import java.util.*;


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
   public boolean addCustomer(String name, String address, int phone, int cardNumber, Calendar expirationDate){
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
   public void addCreditCard(int customerId, int cardNumber, Calendar date) {
	   Customer customer = customerList.getCustomer(customerId);
	   if (customer == null) {
		   throw new RuntimeException("No customer exists with ID: " + customerId);
	   }
	   CreditCard card = new CreditCard(cardNumber, date);
	   customer.addCreditCard(card);
   }
   
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
   
   
   public boolean addShow(String name,String date,int clientId){
    //show id can automatically be added as the length of the array increases. Map array.length to client id
       Show show=new Show(showList.getList().size(),name,date,clientId);
       boolean flag=showList.append(show);
       if(flag)
           return true;
       else
           return false;
   }

   //returns array
   public ArrayList<Show> geShows(){
       return showList.getList();
   }



}
