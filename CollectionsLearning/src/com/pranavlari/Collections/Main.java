package com.pranavlari.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Theater issac = new Theater("Issac",8,12);
//	    issac.getSeats().forEach(seat -> System.out.println(seat.getSeatNo()));
        Scanner scanner = new Scanner(System.in);

        List<Seat> suffedList = new ArrayList<>(issac.getSeats());

        Collections.shuffle(suffedList);
        suffedList.forEach(seat -> System.out.print(" "+seat.getSeatNo()));
        Collections.sort(suffedList,Theater.SORTSEATS);
        System.out.println("");
        suffedList.forEach(seat -> System.out.print(" "+seat.getSeatNo()));
        System.out.println("");
        while (true) {
            System.out.println("Enter a seat no. to reserve (type exit to quit):");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")) {
                break;
            }
            if(issac.reserveSeat(input)) {
                System.out.println("Seat reserved");
            }
            else {
                System.out.println("Seat not found or seat already taken try again!!");
            }
        }
    }
}
