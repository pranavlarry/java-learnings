package com.pranavlari.Collections;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ByteStream {

    public static void main(String[] args) {
        List<String > data= Arrays.asList("0 hello","1,there","2,How","3,Are","4,You");
        try(DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("location.dat")))) {
            data.forEach(d->{
                try {
//                    writer.writeInt(0); //write int
                    writer.writeUTF(d+"\n"); //write string
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            });

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    static  {
        try(DataInputStream reader = new DataInputStream(new BufferedInputStream(new FileInputStream("location.dat")))) {
            while(true) {
                try {
//                    int hii = reader.readInt();
                    String hoy = reader.readUTF();
                    System.out.println(hoy);
                }
                catch (EOFException e) {
                    break;
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
