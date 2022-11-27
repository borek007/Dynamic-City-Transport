package com.company.Company.behaviours;

import com.company.Common.Offer;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ServeOrdersBehaviour extends OneShotBehaviour {


    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
        ACLMessage msg = myAgent.receive(mt);

        if (msg != null) {
            String title = msg.getContent();
            ACLMessage reply = msg.createReply();

            Integer price = Integer.valueOf(title);
            if (price != null) {
                reply.setPerformative(ACLMessage.INFORM);
                System.out.println(title + " Serve Orders " + msg.getSender().getName());
            } else {
                // The requested car has been booked to another customer in the meanwhile .
                reply.setPerformative(ACLMessage.FAILURE);
                reply.setContent("not-available");
            }
            myAgent.send(reply);
        } else {
            block();
        }
    }

}
