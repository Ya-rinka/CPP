package com.company;

public class Customer {
    String name;
    int reservationID;

    Customer(String n, int rID) {
        this.name = n;
        this.reservationID = rID;
    }

    public String getName() {
        return this.name;
    }

    public int getReservationID() {
        return this.reservationID;
    }
}