package com.Project1.classes;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MemberIdFactory implements Serializable {
	private static final long serialVersionUID = 1L;
	private static AtomicInteger idCounter;
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
    
    public int createId() {
    	return idCounter.getAndIncrement();
    }
}
