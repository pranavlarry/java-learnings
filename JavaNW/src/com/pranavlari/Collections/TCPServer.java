package com.pranavlari.Collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)){


            while (true) {
//                //single threaded
//                Socket socket = serverSocket.accept();
//                System.out.println("Client Connected");
//                BufferedReader input = new BufferedReader((new InputStreamReader(socket.getInputStream())));
//                PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
//                String echoStr = input.readLine();
//                if(echoStr.equalsIgnoreCase("exit")){
//                    break;
//                }
//                output.println("From Server: "+ echoStr);
                new Echoer(serverSocket.accept()).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
