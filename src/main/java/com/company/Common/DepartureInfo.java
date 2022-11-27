package com.company.Common;

import jade.core.AID;

import java.time.LocalDateTime;

public class DepartureInfo {

    public int Id;
    public AID carAID;
    public String from;
    public String to;

    public LocalDateTime time;

    public DepartureInfo() { }

    public DepartureInfo(int id, DepartureRegistrationData registrationData) {
        this.Id = id;
        this.carAID = registrationData.getCarAID();
        this.from = registrationData.getFrom();
        this.to = registrationData.getTo();
        this.time = registrationData.getDate();
    }
}
