
package com.company.Company.behaviours;

import com.company.Common.Logger;
import com.company.Common.Offer;
import com.company.Passenger.PassengerAgent;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Vector;


class MakeAnOfferBehaviour extends CyclicBehaviour {

	private int id;
	private LocalDateTime proposedTime;
	private LocalDateTime clientTime;
	private ACLMessage response;

	private boolean sent;
	private ACLMessage message;



	private MessageTemplate messageTemplate;
	private AID sender;

	private int price;

	private Logger logger;


	@Override
	public void onStart() {
		logger.log("Starting Make an Offer");

		message = new ACLMessage(ACLMessage.PROPOSE);

	}

	@Override
	public void action() {

		MessageTemplate messageTemplate = MessageTemplate.MatchPerformative(ACLMessage.CFP);
		ACLMessage msg = myAgent.receive(messageTemplate);
		if (msg != null) {
			String title = msg.getContent();
			ACLMessage reply = msg.createReply();

			Integer price =  PriceDetermination();
			if (price != null) {
				reply.setPerformative(ACLMessage.PROPOSE);
				reply.setContent(String.valueOf(price.intValue()));
			} else {
				reply.setPerformative(ACLMessage.REFUSE);
				reply.setContent("not-available");
			}
			myAgent.send(reply);
		} else {
			block();
		}
	}



	private int PriceDetermination(){

		return 0;
	}



}
