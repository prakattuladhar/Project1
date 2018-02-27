package com.Project1.classes;

import java.io.*;

/**
 * @version 1.0
 * 
 * Represents a person associated with the Theater
 * 
 * @author Colin Quinn
 * 
 */
public abstract class Member implements Serializable {
	private static final long serialVersionUID = 1L;
    protected int id;
    protected String name;
    protected String address;
    protected int phone;
    /**
     * Constructor
     * @param aName		the name of the member
     * @param aAddress	the member's address
     * @param aPhone	the member's phone number
     */
    public Member(String aName, String aAddress, int aPhone) {
    	name = aName;
        address = aAddress;
        phone = aPhone;
        
        //creates unique id number
        this.id = MemberIdFactory.instance().createId();
    }
    /**
     * Gets the member's ID number
     * @return id number
     */
    public int getId() {
        return id;
    }
    /**
     * Gets the member's name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the member's address
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Gets the member's phone number
     * @return phone number
     */
    public int getPhone() {
        return phone;
    }
    /**
     * Used to detect duplicate members
     * @param member
     * @return
     */
    public boolean equals(Member member) {
    	if (
    			name.equals( member.getName() ) &&
    			address.equals( member.getAddress() )
    		) {
    		return true;
    	}
    	return false;
    }
    /**
     * String representation of member's fields
     */
    @Override
    public String toString() {
    	return "ID: " + id + ", Name: " + name + ", Address: " + address +
    			"Phone: " + phone;
    }

}
