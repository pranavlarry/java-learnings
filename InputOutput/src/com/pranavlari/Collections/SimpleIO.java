package com.pranavlari.Collections;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleIO {

    public static void main(String[] args) {
        //writing to file

        List<String > data= Arrays.asList("0,hello","1,there","2,How","3,Are","4,You");

        //buffered writer
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("location.txt"))) {
            data.forEach(d->{
                try {
                    writer.write(d+"\n");
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }

//        try(FileWriter writer = new FileWriter("location.txt")) {
//             data.forEach(d->{
//                try {
//                    writer.write(d+"\n");
//                }
//                catch (IOException e){
//                    e.printStackTrace();
//                }
//            });
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        try {

            //reading from file

//            Scanner scanner = new Scanner(new FileReader("location.txt"));
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()) {
//                int hello = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String hii = scanner.next();
//                System.out.println(hello+" "+hii);
//            }

            //reading using bufferd reader more efficent
            Scanner scanner = new Scanner(new BufferedReader( new FileReader("location.txt") ));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                int hello = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String hii = scanner.nextLine();
                System.out.println(hello+" "+hii);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
