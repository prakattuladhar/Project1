package com.Project1.classes;

import java.io.*;
import java.util.concurrent.atomic.*;

public abstract class Member implements Serializable {
	private static final long serialVersionUID = 1L;
    protected int id;
    protected String name;
    protected String address;
    protected int phone;

    public Member(String name, String address, int phone) {
        this.address = address;
        this.name = name;
        this.phone = phone;
        
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



}
