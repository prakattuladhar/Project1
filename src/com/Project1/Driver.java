package com.Project1;

import com.Project1.classes.Client;
import com.Project1.classes.ClientList;
import com.Project1.classes.Theater;

import java.util.Scanner;

public class Driver {
    private Scanner keyboard=new Scanner(System.in);
    private Theater theater=Theater.getInstance();
    public void start(){
        int option;
        do{
            printOptions();
            System.out.print("Please Select a Option: ");
            option=keyboard.nextInt();

            switch (option){
                case 1: {
                    System.out.println("Thayou for using");
                    System.exit(100);
                    break;
                }
                case 2:{
                    theater.addClient("asd","asd",123);
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    for (Client client:theater.getAllClient()){
                            System.out.println("\n-------------------------------------");
                            System.out.println("Id:"+client.getId());
                            System.out.println("Name:"+client.getName());
                             System.out.println("Phone:"+client.getPhone());
                            System.out.println("Address: "+client.getAddress());
                             System.out.println("Balance:"+client.getBalance());
                            System.out.print("-------------------------------------");
                    }
                    break;
                }
                case 5:{
                    break;
                }
                case 6:{
                    break;
                }
                case 7:{
                    break;
                }
                case 8:{
                    break;
                }
                case 9:{
                    break;
                }
                case 10:{
                    break;
                }
                case 11:{
                    break;
                }
                case 13:{
                    break;
                }
                case 14: {
                    printHelp();
                    break;
                }
                default: {
                    System.out.println("Invalid Input\n");
                    break;
                }
            }
        }while(option!=1);
    }

    private void printOptions(){
        System.out.println("1. Exit Application\n2. Add Client\n3. Remove Client\n4.List all CLients\n" +
                "5. Add Customer\n6. Remove customer\n7.Add credit card\n8. Remove Credit card\n9. List all customers" +
                "\n10. Add a show/play\n11. List all shows\n12. Store Data\n13. Retrive data\n14.Help");
    }

    private void printHelp(){
        System.out.println("1. Exit the Application. Store the data on disk and quit the application." +
                " \n2. Add Client. The system accepts the name, address, and phone number of the client. The system\n" +
                "generates a unique id and sets the balance to 0. (The balance will remain 0 in this iteration.)" +
                "\n3. Remove Client. Remove a client with the given id. If a show is scheduled for the current or a\n" +
                "future date for this client, the client cannot be removed." +
                "\n4.. List all Clients. Print information about every client." +
                "\n" +
                "5. Add Customer. The system accepts the name, address, phone number, and the number and\n" +
                "expiry date of exactly one credit card. The system generates a unique id for the customer." +
                "\n6. Remove Customer. Remove a customer with the given id. All credit cards related to the\n" +
                "customer are also deleted." +
                "\n7. Add a Credit Card. The system accepts the customer id, credit card number, and expiry date and\n" +
                "remembers that the credit card belongs to this customer." +
                "\n8. Remove a Credit Card. The system accepts the credit card number and removes the information\n" +
                "related to the credit card. If this is the only credit card for the customer, it refuses to delete the\n" +
                "credit card information." +
                "\n9.List all Customers. Print information about every client, including credit card information." +
                "\n10.Add a Show/Play. Add a new show for a client. The values accepted are the name of the show,\n" +
                "the client id, and the period for which the client wants the theater for this play. The entire range\n" +
                "of dates should be available, or the process fails." +
                "\n11.List all Shows. List the names and dates of all shows" +
                "\n12. Store Data. Store all data related to the theater (everything, including customers, shows,\n" +
                "clients, etc.) on disk." +
                "\n13. . Retrieve Data. Retrieve all information related to the theater. This may be done at the start of\n" +
                "any session. If stored data is found, the user has the option to use it. The user may also invoke\n" +
                "a command to load data, provided he/she has not yet issued any data-related commands in\n" +
                "that session." +
                "\n14.Help: Display help\n");
    }

    private void addClient(){

    }

    private void removeClient(){

    }

    private void listClient(){

    }

    private void addCustomer(){

    }
    private void removeCustomer(){

    }
    private void addCreditCard(){

    }
    private void removeCreditCard(){

    }
    private void listCustomers(){

    }
    private void addShow(){

    }
    private void listShow(){

    }
    private void save(){

    }
    private void load(){

    }

}
