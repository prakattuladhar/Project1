package com.Project1.classes;

import java.io.*;

public abstract class Member implements Serializable {
	private static final long serialVersionUID = 1L;
    protected int id;
    protected String name;
    protected String address;
    protected int phone;

    public Member(String aName, String aAddress, int aPhone) {
    	name = aName;
        address = aAddress;
        phone = aPhone;
        
        //creates unique id number
        this.id = MemberIdFactory.instance().createId();
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
    
    public boolean equals(Member member) {
    	if (
    			name.equals( member.getName() ) &&
    			address.equals( member.getAddress() )
    		) {
    		return true;
    	}
    	return false;
    }

    @Override
    public String toString() {
    	return "ID: " + id + ", Name: " + name + ", Address: " + address +
    			"Phone: " + phone;
    }

}
