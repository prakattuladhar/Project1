package com.Project1.classes;

import java.io.*;
import java.util.concurrent.atomic.*;

public abstract class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// used to create unique id numbers
	private static AtomicInteger idCounter = new AtomicInteger();
	
    protected int id;
    protected String name;
    protected String address;
    protected int phone;

    public Member(String name, String address, int phone) {
        this.address = address;
        this.name = name;
        this.phone = phone;
        
        //creates unique id number
        this.id = idCounter.getAndIncrement();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }



}
