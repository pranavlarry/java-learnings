package com.pranavlari.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Theater {

    private final String name;
    private List<Seat> seats = new ArrayList<>();

    /* s1 < s2 --> -1
        s1 > s2 --> 1
        s1 == s2 --> 0
     */
    public static final Comparator<Seat> SORTSEATS = (s1,s2) -> s1.getSeatNo().compareToIgnoreCase(s2.getSeatNo());

    public Theater(String name, int noRow, int seatsPerRow) {
        this.name = name;

        int lastRow = 'A' + (noRow - 1);

        for(char row = 'A'; row <= lastRow; row++ ) {
            for(int seat = 1; seat< seatsPerRow ; seat++) {
                seats.add(new Seat(row+ String.format("%02d",seat)));
            }
        }
    }

    public boolean reserveSeat(String seatNo) {
        Seat searchSeat = new Seat(seatNo);
        int seatIndex = Collections.binarySearch(seats,searchSeat,null);
        if(seatIndex >=0) {
            return seats.get(seatIndex).reserve();
        }
        return false;
    }


    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

}
