package com.Project1.classes;

import java.util.*;
import java.io.*;
/**
 * 
 * 
 * @author Colin Quinn
 *
 */
public class ClientList implements Iterable<Client>, Serializable {
	private static final long serialVersionUID = 1L;
	// allows for search, add, and remove in O(lg(n)) time
    private TreeMap<Integer, Client> map = new TreeMap<Integer, Client>();
    /**
     * adds a client to the list
     * @param client
     * @return true if added, false if client already in list
     */
    public boolean add(Client client){
        map.put(client.getId(), client);
        return true;
    }
    /**
     * 
     * @param id
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
     * 
     * @return count of clients in list
     */
    public int size() {
    	return map.size();
    }
    
    @Override
    public Iterator<Client> iterator() {
    	return map.values().iterator();
    }
}
