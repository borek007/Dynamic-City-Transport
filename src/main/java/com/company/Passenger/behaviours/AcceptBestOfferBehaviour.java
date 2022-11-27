
package com.company.Passenger.behaviours;

import java.util.Date;
import java.util.Vector;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import com.company.Common.*;


class AcceptBestOfferBehaviour extends OneShotBehaviour {

	private Logger logger;
	private Agent agent;
	private Vector<Offer> offers;

	public AcceptBestOfferBehaviour(Agent agent, Logger logger, Vector<Offer> offers) {
		super(agent);
		this.agent = agent;	
		this.logger = logger;	
		this.offers = offers;
	}

	public void action() {
		this.logger.log("TODO: choosing best offer");
		// Trigger accepting the best offer.
		// After accepting it trigger behaviour waiting for a pick up.
		// Should we reject every other?.
	} 

}
