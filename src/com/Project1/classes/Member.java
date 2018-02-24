package com.Project1.classes;

public abstract class Member {
    protected int id;
    protected String name;
    protected String address;
    protected int phone;

    public Member(int id,String name, String address, int phone) {
        this.address=address;
        this.name=name;
        this.phone=phone;
        this.id=id;
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
