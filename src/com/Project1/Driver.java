package com.Project1;

import com.Project1.classes.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.time.*;
import java.time.format.*;

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
                    System.out.print("Confirm exit program? Enter Y for yes: ");
                    String opt=keyboard.next();
                    if(opt.toLowerCase().equals('y')) {
                        save();
                        System.out.println("Thank you for using");
                        System.exit(100);
                    }
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
                case 14:{
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
    private LocalDate getShowDate() {
    	do {
    		try {
        		String line = keyboard.nextLine();
        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        		// Allow user to return to menu
//        		if ( line.equalsIgnoreCase("q") ) {
//        			
//        		}
        	    LocalDate date = LocalDate.parse(line, formatter);
        	    return date;
        	} catch (Exception fe) {
        		System.out.println("Invalid Date: Please use format mm/dd/yyyy");
        	}
    	} while (true);
    }
    private YearMonth getExpirationDate() {
    	do {
    		try {
        		String line = keyboard.nextLine();
        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/yyyy");
        		// Allow user to return to menu
//        		if ( line.equalsIgnoreCase("q") ) {
//        			
//        		}
        	    YearMonth date = YearMonth.parse(line, formatter);
        	    return date;
        	} catch (Exception fe) {
        		System.out.println("Invalid Date: Please use format mm/yyyy");
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

        theater.addClient(name, address, phone);
        
        System.out.println("Client added");
    }
    /**
     * Removes a client based on member id
     */
    // needs to check collection of shows to ensure client has no shows
    private void removeClient() {
        System.out.print("Input client number: ");
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
        YearMonth expirationDate = getExpirationDate();

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
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
    	
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
            			card.getExpirationDate().format(formatter) );
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
        YearMonth date = getExpirationDate();
        
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

        System.out.print("Enter credit card number: ");
        int number = Integer.parseInt( keyboard.nextLine() );
        
        try {
        	theater.removeCreditCard(id, number);
        } catch (RuntimeException exception) {
        	System.out.println( exception.getMessage() );
        }

    }
    /**
     * 
     */
    private void addShow() {
    	System.out.print("Enter client id: ");
        int clientId = Integer.parseInt( keyboard.nextLine() );
        
        System.out.print("Enter name of the show: ");
        String name = keyboard.nextLine();
        
        System.out.print("Enter start date for show: ");
        LocalDate startDate = getShowDate();
        
        System.out.print("Enter end date for show: ");
        LocalDate endDate = getShowDate();
        
        LocalDate currentDate = LocalDate.now();
        if (startDate.compareTo(currentDate) <= 0) {
        	System.out.println("Show must start on or after current date");
        	return;
        }
        
        if (startDate.compareTo(endDate) > 0) {
        	System.out.println("End date must be on or after start date");
        	return;
        }
        
        try {
        	theater.addShow(clientId, name, startDate, endDate);
        } catch (ShowConflictException se) {
        	System.out.println("Add Failed: ");
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        	if (se.conflictingShows[0] != null) {
        		Show previous = se.conflictingShows[0];
        		String date = previous.getEndDate().format(formatter);
        		System.out.println("New show must start after previous show ends at " + date);
        	}
        	if (se.conflictingShows[1] != null) {
        		Show next = se.conflictingShows[1];
        		String date = next.getEndDate().format(formatter);
        		System.out.println("New show must end before next show starts at " + date);
        	}
        } catch (RuntimeException re) {
        	System.out.println("Add failed: show must be scheduled after current date");
        }
        System.out.println("Show added");
    }


    //prints all the shows
    private void listShow() {
    	Iterator<Show> iterator = theater.getShowIterator();
        while ( iterator.hasNext() ) {
        	Show show = iterator.next();
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            System.out.println("\n---------------------------------------");
            System.out.println("Id: " + show.getClientId() );
            System.out.println("Name: " + show.getName() );
            System.out.println("Start date: " + show.getStartDate().format(formatter) );
            System.out.println("End date: " + show.getEndDate().format(formatter) + "\n");
           // System.out.println("Customers: "+show.getCustomerId());
        }
        System.out.println("\n---------------------------------------");
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
