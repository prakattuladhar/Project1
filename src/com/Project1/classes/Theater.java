package com.Project1.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Theater implements Serializable{
   private CustomerList customerList= new CustomerList();
   private ClientList clientList=new ClientList();
   private ShowList showList=new ShowList();

   public int[] x=new int[10];
   private static Theater theater;
   private Theater(){

   }
   public static Theater getInstance(){
       if(theater==null)
           theater=new Theater();
       return theater;
   }
   public void setTheater(Theater object){
       this.theater=object;
   }


   public void addClient(String name,String address, int phone){
    //client id can automatically be added as the length of the array increases. Map array.length to client id
       Client client= new Client(clientList.getList().size(),name,address,phone);
       clientList.append(client);

   }
   public void removeClient(int id){

   }

   //returns back an list of customers(array)
   public ArrayList<Customer> getAllCustomer(){
       return customerList.getList();
   }

   //returns back an list of clients(array)
   public ArrayList<Client> getAllClient(){
       return clientList.getList();
   }

   public void addCustomer(String name,String address, int phone, int cardNumber, String expirationDate){

   }
   public void removeCustomer(int id) {

   }
   public void addShow(String name,String date,int clientId){
//show id can automatically be added as the length of the array increases. Map array.length to client id
   }
   public ArrayList<Show> geShows(){
       return showList.getList();
   }



}
