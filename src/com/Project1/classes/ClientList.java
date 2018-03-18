package com.Project1.classes;

import java.util.*;
import java.io.*;
/**
 * @version 1.0
 * 
 * This class represents a collection of clients
 * 
 * @author Colin Quinn
 *
 */
public class ClientList implements Iterable<Client>, Serializable {
	private static final long serialVersionUID = 1L;
	// allows for search, add, and remove in O(lg(n)) time
    private TreeMap<Integer, Client> map = new TreeMap<Integer, Client>();
    /**
     * Adds a client to the list
     * @param client
     * @return true if added, false if client already in list
     */
    public boolean add(Client client){
        map.put(client.getId(), client);
        return true;
    }
    /**
     * Removes a client from the list
     * Client may not be removed if they have a show in the show list
     * @param id			ID number of client for the show
     * @param:showList		list of shows for theater
     * @return client that was removed, or null if client did not exist
     * @RuntimeException if client has at least one show scheduled
     */
    public Client remove(int id, ShowList list){
    	if ( list.ClientHasShow(id) ) {
    		throw new RuntimeException("Cannot remove a client with a show scheduled");
    	}
    	return map.remove(id);
    }
    /**
     * Returns  client associated with ID, or null if no such client
     * @param clientId			ID number of client
     * @return Client			client associated with that ID
     */
    public Client getClient(int clientId) {
    	return map.get(clientId);
    }
    /**
     * Gets the count of clients in the client list
     * @return count of clients in list
     */
    public int size() {
    	return map.size();
    }
    /**
     * Gets an iterator of the clients
     * @return Iterator<Client>
     */
    @Override
    public Iterator<Client> iterator() {
    	return map.values().iterator();
    }
}
