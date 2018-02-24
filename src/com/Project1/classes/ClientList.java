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
    private TreeMap<Integer, Client> map = new TreeMap<Integer, Client>();
    /**
     * 
     * @param client
     */
    public void add(Client client){
        map.put(client.getId(), client);
    }
    /**
     * client's id
     * @param id
     */
    public void remove(int id){
    	map.remove(id);
    }
    
    public Iterator<Client> iterator() {
    	return map.values().iterator();
    }
}
