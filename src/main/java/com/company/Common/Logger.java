package com.company.Common;

import jade.lang.acl.ACLMessage;

public class Logger {

    private String agentName;

	public Logger(String agentName) {
		this.agentName = agentName;
	}

    public void log(String message){
		System.out.println(agentName + ":\n" + message + "\n");
    }

    public void log(ACLMessage message){
		System.out.println(agentName + ":\n" + message + "\n");
    }

    public void logSend(ACLMessage message){
		System.out.println(agentName + ":\nsending:\n:" + message + "\n");
    }

    public void logReceived(ACLMessage message){
		System.out.println(agentName + ":\nreceived:\n:" + message + "\n");
    }
}
