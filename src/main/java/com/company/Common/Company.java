package com.company.Common;

import jade.core.AID;

import java.util.Hashtable;
import java.util.Vector;

public class Company {
    private int id;
    private String name;
    private AID agentAID;
    private int score;
    private String address;
    private int budget;

    // private List<RegisteredVehicle> registeredVehicles = new Araylist<>();
    // private List<City> registeredCities = new Araylist<>();

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public AID getAgentAID() {
        return agentAID;
    }

    public void setAgentAID(AID agentAID) {
        this.agentAID = agentAID;
    }



}
