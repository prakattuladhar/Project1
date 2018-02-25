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


   /**
    * adds a new client
    * @param name
    * @param address
    * @param phone
    * @return true if client was added, false if client already exists
    */
   public boolean addClient(String name,String address, int phone){
	   Client client = new Client(name , address, phone);
       return clientList.add(client);

   }
   public boolean removeClient(int id){
       //true if successful
        return false;
   }

   //returns back an list of customers(array)
   public Iterator<Customer> getCustomerIterator(){
       return customerList.iterator();
   }

   //returns back an list of clients(array)
   public Iterator<Client> getClientIterator(){
       return clientList.iterator();
   }
    /**
     * Adds a new customer
     * @param name
     * @param address
     * @param phone
     * @param cardNumber
     * @param expirationDate
     * @return true if customer added, false if customer already exists
     */
   public boolean addCustomer(String name, String address, int phone, int cardNumber, String expirationDate){
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
   public void addShow(String name,String date,int clientId){
    //show id can automatically be added as the length of the array increases. Map array.length to client id
   }

   //returns array
   public ArrayList<Show> geShows(){
       return showList.getList();
   }



}
