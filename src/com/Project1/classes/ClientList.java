package com.Project1.classes;

import java.util.ArrayList;

public class ClientList {
    private ArrayList<Client> list=new ArrayList<Client>();

    public void append(Client client){
        list.add(client);
    }
    public void remove(int id){

    }
    public ArrayList<Client> getList() {
        return list;
    }
}
