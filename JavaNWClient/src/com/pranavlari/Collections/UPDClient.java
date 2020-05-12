package com.pranavlari.Collections;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UPDClient {

    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String input;

            while (true) {

                System.out.println("Enter Something: ");
                input = scanner.nextLine();

                byte[] buffer = input.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,5000);
                socket.send(packet);

                packet = new DatagramPacket(buffer,buffer.length);
                //usually don't wait for resp in udp connection
                socket.receive(packet);
                System.out.println(new String(buffer,0,packet.getLength()));

                if(input.equalsIgnoreCase("exit")){
                    break;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
