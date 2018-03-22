package com.Project1;

import com.Project1.classes.Theater;
import com.Project1.classes.MemberIdFactory;
import com.Project1.classes.TicketFactory;

import java.io.*;
/**
 * @version 2.0
 * 
 * Class to read and write Theater, MemberIdFacotyr, and TicketFactory objects to file:
 * output.dat
 * 
 * @author Prakat Tuladhar
 *
 */
public class FileHandler  {


    /**
     * Writes theater/MemberIdFactory/TicketFactory objects to file
     * @param object theater
     * @throws IOException
     */
    public static void writeToFile(Theater object) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("output.dat");//output file name output.dat
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(object);
        objectOut.writeObject( MemberIdFactory.instance() );
        objectOut.writeObject( TicketFactory.instance() );
        objectOut.close();
        fileOut.close();

    }

    /**
     * Reads theater/MemberIdFactory/TicketFactory from file
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Theater readFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("output.dat");//input file name output.dat
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Theater object = (Theater) objectIn.readObject();
        MemberIdFactory.retrieve(objectIn);
        TicketFactory.retrieve(objectIn);
        
        objectIn.close();
        fileIn.close();
        return object;
    }
}
