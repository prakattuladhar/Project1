package com.Project1;

import com.Project1.classes.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

<<<<<<< HEAD
import java.io.File;
import java.io.IOException;
=======
import java.text.DateFormat;
import java.text.SimpleDateFormat;
>>>>>>> refs/heads/getDates
import java.util.*;
import java.time.*;

//prakat will code this
public class Driver {
    private Scanner keyboard = new Scanner(System.in);
    private Theater theater = Theater.getInstance();

    public void start() {
        int option;
        do {
        	option = -1;		// Sentinel value for invalid input
            printOptions();
            System.out.print("Please Select a Option: ");

            try {
            	// Allows better error checking and doesn't leave dangling "\n"
            	option = Integer.parseInt( keyboard.nextLine() );
            } catch (Exception exception) {
            	;
            }

            switch (option) {
                case 1: {
                    System.out.println("Thank you for using");
                    System.exit(100);
                    break;
                }
                case 2: {
                    addClient();
                    break;
                }
                case 3: {
                    removeClient();
                    break;
                }
                case 4: {
                    listClient();
                    break;
                }
                case 5: {
                    addCustomer();
                    break;
                }
                case 6: {
                    removeCustomer();
                    break;
                }
                case 7: {
                    addCreditCard();
                    break;
                }
                case 8: {
                    removeCreditCard();
                    break;
                }
                case 9: {
                    listCustomers();
                    break;
                }
                case 10: {
                    addShow();
                    break;
                }
                case 11: {
                    listShow();
                    break;
                }
                case 12: {
                    save();
                    break;
                }
                case 13: {
                    load();
                    break;
                }
                case 14: {
                    printHelp();
                    break;
                }
                default: {
                    System.out.println("Invalid Input:  Please enter a number from 0 to 14\n");
                    break;
                }
            }
        } while (option != 1);
    }


    private void printOptions() {
        System.out.print("----------------------------------------------");
        System.out.println("\n1. Exit Application\n2. Add Client\n3. Remove Client\n4.List all CLients\n" +
                "5. Add Customer\n6. Remove customer\n7.Add credit card\n8. Remove Credit card\n9. List all customers" +
                "\n10. Add a show/play\n11. List all shows\n12. Store Data\n13. Retrive data\n14.Help");
    }

    private void printHelp() {
        System.out.print("----------------------------------------------");
        System.out.println("\n1. Exit the Application. Store the data on disk and quit the application." +
                " \n\n2. Add Client. The system accepts the name, address, and phone number of the client. The system\n" +
                "generates a unique id and sets the balance to 0. (The balance will remain 0 in this iteration.)" +
                "\n\n3. Remove Client. Remove a client with the given id. If a show is scheduled for the current or a\n" +
                "future date for this client, the client cannot be removed." +
                "\n\n4.. List all Clients. Print information about every client." +
                "\n\n" +
                "5. Add Customer. The system accepts the name, address, phone number, and the number and\n" +
                "expiry date of exactly one credit card. The system generates a unique id for the customer." +
                "\n\n6. Remove Customer. Remove a customer with the given id. All credit cards related to the\n" +
                "customer are also deleted." +
                "\n\n7. Add a Credit Card. The system accepts the customer id, credit card number, and expiry date and\n" +
                "remembers that the credit card belongs to this customer." +
                "\n\n8. Remove a Credit Card. The system accepts the credit card number and removes the information\n" +
                "related to the credit card. If this is the only credit card for the customer, it refuses to delete the\n" +
                "credit card information." +
                "\n\n9.List all Customers. Print information about every client, including credit card information." +
                "\n\n10.Add a Show/Play. Add a new show for a client. The values accepted are the name of the show,\n" +
                "the client id, and the period for which the client wants the theater for this play. The entire range\n" +
                "of dates should be available, or the process fails." +
                "\n\n11.List all Shows. List the names and dates of all shows" +
                "\n\n12. Store Data. Store all data related to the theater (everything, including customers, shows,\n" +
                "clients, etc.) on disk." +
                "\n\n13. Retrieve Data. Retrieve all information related to the theater. This may be done at the start of\n" +
                "any session. If stored data is found, the user has the option to use it. The user may also invoke\n" +
                "a command to load data, provided he/she has not yet issued any data-related commands in\n" +
                "that session." +
                "\n\n14.Help: Display help\n");
    }
    
    // User input methods
    /**
     * gets integer entered by user
     * @return integer
     */
    private int getInt() {
    	int response = -1;
    	String line;
    	
    	do {
    		line = keyboard.nextLine();
    		try {
    			response = Integer.parseInt( line );
    		} catch (Exception exception) {
    			System.out.println("Invalid Input: Please enter a number");
    		}
    		// Allow user to return to menu
//    		if ( line.equalsIgnoreCase("q") ) {
//    			throw new RuntimeException();
//    		}
    	} while (response == -1);
    	return response;
    }
    /**
     * Gets a date based on format passed to it
     * @param format
     * @return
     * @throws Exception
     */
    private Calendar getDate(String format) throws Exception {
    	String line;
    	Calendar date = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        
    	try {
    		line = keyboard.nextLine();
    		// Allow user to return to menu
//    		if ( line.equalsIgnoreCase("q") ) {
//    			
//    		}
    	    date.setTime( formatter.parse(line) );
    	    return date;
    	} catch (Exception fe) {
    	    throw fe;
    	}
    }
    private Calendar getShowDate() {
    	do {
    		try {
    			return getDate("mm/dd/yyyy");
    		} catch (Exception e) {
    			System.out.println("Invalid Date: Please use format mm/dd/yyy");
    		}
    	} while (true);
    }
    private Calendar getExpirationDate() {
    	do {
    		try {
    			return getDate("mm/dd");
    		} catch (Exception e) {
    			System.out.println("Invalid Date: Please use format mm/dd");
    		}
    	} while (true);
    }
    
    // Client methods
    /**
     * Adds a client
     */
    private void addClient() {
        System.out.println("Input name: ");
        String name = keyboard.nextLine();

        System.out.println("Input Address: ");
        String address = keyboard.nextLine();

        System.out.println("Input Phone: ");
        int phone = Integer.parseInt( keyboard.nextLine() );

        boolean clientExists=theater.addClient(name, address, phone);
        

        if (!clientExists) {
        	System.out.println("Client add failed");
        } else {
        	System.out.println("Client added");
        }

    }
    /**
     * Removes a client based on member id
     */
    // needs to check collection of shows to ensure client has no shows
    private void removeClient() {
        System.out.print("Input Client number: ");
        int id = Integer.parseInt( keyboard.nextLine() );
        theater.removeClient(id);
    }
    /**
     * Lists information for every client
     */
    private void listClient() {
    	Iterator<Client> iterator = theater.getClientIterator();
        while ( iterator.hasNext() ) {
        	Client client = iterator.next();
            System.out.println("\n-------------------------------------");
            System.out.println( "Id: " + client.getId() );
            System.out.println( "Name: " + client.getName() );
            System.out.println( "Phone: " + client.getPhone() );
            System.out.println( "Address: " + client.getAddress() );
            System.out.println( "Balance: " + client.getBalance() );
            System.out.println("-------------------------------------\n");
        }
    }
    
    // Customer methods
    /**
     * Adds a customer
     */
    private void addCustomer() {
        System.out.print("Input name: ");
        String name = keyboard.nextLine();

        System.out.print("Input Address: ");
        String address = keyboard.nextLine();

        System.out.print("Input Phone: ");
        int phone = Integer.parseInt( keyboard.nextLine() );

        System.out.print("Input creditcard number: ");
        int cardNumber = Integer.parseInt( keyboard.nextLine() );

        System.out.print("Input expiration date: ");
        Calendar expirationDate = getExpirationDate();

        theater.addCustomer(
        		name, address, phone, cardNumber, expirationDate);
        
        System.out.println("Customer added");
        
    }
    /**
     * Deletes a customer based on member id
     */
    private void removeCustomer() {
        System.out.print("Enter customer id: ");
        int id = Integer.parseInt( keyboard.nextLine() );
        
        String deleted = theater.removeCustomer(id);
        
        if (deleted == null) {
        	System.out.print("No customer exists for ID: " + id);
        } else {
        	System.out.print("Deleted customer: " + deleted);
        }

    }
    /**
     * Lists information for every customer
     */
    private void listCustomers() {
    	SimpleDateFormat formatter = new SimpleDateFormat("mm/dd");
    	
    	Iterator<Customer> iterator = theater.getCustomerIterator();
        while ( iterator.hasNext() ) {
        	Customer customer = iterator.next();
            System.out.println("\n-------------------------------------");
            System.out.println( "Id: " + customer.getId() );
            System.out.println( "Name: " + customer.getName() );
            System.out.println( "Phone: " + customer.getPhone() );
            System.out.println( "Address: " + customer.getAddress() );
            Iterator<CreditCard> cards = customer.getCreditCardIterator();
            System.out.println("Credit cards:" + customer.getCreditCardCount() );
            while ( cards.hasNext() ) {
            	CreditCard card = cards.next();
            	System.out.println( "\tNumber: " + card.getNumber() );
            	System.out.println( "\tExpiration date: " +
            			formatter.format( card.getExpirationDate().getTime() ) );
            }
            System.out.print("-------------------------------------\n");
        }
    }

    // Credit card methods
    /**
     * Adds a credit card to a specific customer
     */
    private void addCreditCard() {
        System.out.print("Enter customer id: ");
        int id = Integer.parseInt( keyboard.nextLine() );

        System.out.print("Enter credit card number : ");
        int number = Integer.parseInt( keyboard.nextLine() );

        System.out.print("Enter expiration date : ");
        Calendar date = getExpirationDate();
        
        try {
        	theater.addCreditCard(id, number, date);
        } catch (RuntimeException exception) {
        	System.out.println( exception.getMessage() );
        }
    }
    /**
     * Delete a credit card for a specific customer
     */
    private void removeCreditCard() {
        System.out.print("Enter customer id: ");
        int id = Integer.parseInt( keyboard.nextLine() );

        System.out.print("Enter credit card numebr : ");
        int number = Integer.parseInt( keyboard.nextLine() );
        
        try {
        	theater.removeCreditCard(id, number);
        } catch (RuntimeException exception) {
        	System.out.println( exception.getMessage() );
        }

    }

    private void addShow() {
        System.out.print("Enter date for show: ");
        String date=keyboard.nextLine();
        System.out.print("Enter client id: ");
        int clientId = Integer.parseInt( keyboard.nextLine() );
        System.out.print("Enter name of the show: ");
        String name=keyboard.nextLine();


        if(theater.addShow(name,date,clientId))
            System.out.println("successfully added");
        else
            System.out.println("Adding show falined");

    }

    private void listShow() {

        for(Show show:theater.geShows()){
            System.out.println("\n---------------------------------------");
            System.out.println("Id:"+show.getId() );
            System.out.println("Date:"+ show.getDate());
            System.out.println("Name:"+ show.getName());
            System.out.println("Client:"+ show.getClientId());
           // System.out.println("Customers: "+show.getCustomerId());
        }
        System.out.println("\n---------------------------------------");
    }
    private void removeShow() {

    }


    private void save() {
        try {
            FileHandler.writeToFile(theater);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {
        try {
            theater= FileHandler.readFromFile("output.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
