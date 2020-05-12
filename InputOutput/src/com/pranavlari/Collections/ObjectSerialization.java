package com.pranavlari.Collections;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectSerialization {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee(1, "Lari", "Development"),
                new Employee(2,"Pranav","Aricitect"),
                new Employee(3,"Kabali","Lead Developer"));
        //Object stream implements Data stream so it supports writeInt writeUTF etc we can mix objects with primitive types
        try(ObjectOutputStream writer = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("objects.dat")))) {
            writer.writeObject(employees);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream reader= new ObjectInputStream(new BufferedInputStream(new FileInputStream("objects.dat")))) {
            while (true) {
                try {
                    Object readList = reader.readObject();
                    if(readList instanceof List) {
                        List<Employee> hello = (List) readList;
                        System.out.println(hello.get(2).getName());
                    }
                }
                catch (EOFException e) {
                    break;
                }
            }

        }
        catch ( IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
}
