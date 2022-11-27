package com.company.Common;

import jade.core.AID;

import java.time.LocalDateTime;

public class DepartureRegistrationData {
    private AID carAID;
    private int carId;
    private String from;
    private String to;


    private LocalDateTime date;

    public AID getCarAID() {
        return carAID;
    }

    public void setCarAID(AID carAID) {
        this.carAID = carAID;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

