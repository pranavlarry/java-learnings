package com.pranavlari.Collections;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/*
-unreliable but fast
-tcp creates an end to end connection but udp don't
 */
public class UDPServer {

    public static void main(String[] args) {

        try(DatagramSocket socket = new DatagramSocket(5000)) {
            byte[] buffer = new byte[50];
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            socket.receive(packet);
            System.out.println(new String(buffer,0,packet.getLength()));

            InetAddress address = packet.getAddress();
            int port = packet.getPort();

            String returnStr = new String(buffer,0,packet.getLength());
            byte[] returnByte = returnStr.getBytes();
            packet = new DatagramPacket(returnByte,returnByte.length,address,port);
            socket.send(packet);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
