package com.pranavlari.Collections;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) {
	// write your code here
        try(Socket socket = new Socket("localhost",5000)) {
            socket.setSoTimeout(5000);
            BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("Enter any thing");
                String text = scanner.nextLine();
                writer.println(text);

                if(text.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println(reader.readLine());

            }while (true);

        }
        catch (SocketTimeoutException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
