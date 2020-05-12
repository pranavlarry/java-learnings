package com.pranavlari.Collections;

public class Seat implements Comparable<Seat> {
    private String seatNo;
    private boolean reserved=false;

    public Seat(String seatNo) {
        this.seatNo = seatNo;
    }

    public boolean reserve() {
        if(!reserved) {
            this.reserved = true;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Seat seat) {
        return this.seatNo.compareToIgnoreCase(seat.seatNo);
    }

    public boolean cancel() {
        if(reserved) {
            this.reserved = false;
            return true;
        }
        return false;
    }

    public String getSeatNo() {
        return seatNo;
    }
}
