package com.Project1;/*
@aurthor: Prakat Tuladhar
Class to read and write Drawing object to file.
* */

import com.Project1.classes.Theater;

import java.io.*;
import java.util.ArrayList;

public class FileHandler  {


    //writes object to file
    //@params: (Object: Drawings)
    public static void writeToFile(Theater object) throws IOException {
        FileOutputStream fileOut=new FileOutputStream("output.dat");//output file name output.dat
        ObjectOutputStream objectOut=new ObjectOutputStream(fileOut);

        objectOut.writeObject(object);
        objectOut.close();
        fileOut.close();

    }

    //reads object form file
    //return Drawing object
    public static Theater readFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIn=new FileInputStream("output.dat");//input file name output.dat
        ObjectInputStream objectIn=new ObjectInputStream(fileIn);
        Theater object= (Theater) objectIn.readObject();
        objectIn.close();
        fileIn.close();
        return object;
    }
}
