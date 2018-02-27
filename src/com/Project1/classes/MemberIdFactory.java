package com.Project1.classes;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * 
 * This class is used to create unique IDs for members
 * 
 * @author Colin Quinn
 *
 */
public class MemberIdFactory implements Serializable {
	private static final long serialVersionUID = 1L;
	private AtomicInteger idCounter;
	private static MemberIdFactory factory;
	
	private MemberIdFactory() {
		idCounter = new AtomicInteger(0);
    }
    
    /**
     * Supports the singleton pattern
     * 
     * @return the singleton object
     */
    public static MemberIdFactory instance() {
    	if (factory == null) {
    		return ( factory = new MemberIdFactory() );
    	} else {
    		return factory;
    	}
    }
    /**
     * Create a unique member ID
     * @return member ID
     */
    public int createId() {
    	return idCounter.getAndIncrement();
    }
    /**
     * Retrieves the factory
     * 
     * @param input inputstream for deserialization
     */
    public static void retrieve(ObjectInputStream input) {
      try {
        factory = (MemberIdFactory) input.readObject();
      } catch(IOException ioe) {
        ioe.printStackTrace();
      } catch(Exception cnfe) {
        cnfe.printStackTrace();
      }
    }
}
