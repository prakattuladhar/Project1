package com.Project1.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class ShowList implements Serializable {
    private ArrayList<Show> list=new ArrayList<Show>();

    public boolean append(Show show){
        list.add(show);
        return true;
    }
    public void remove(int id){

    }
    public ArrayList<Show> getList() {
        return list;
    }
}
