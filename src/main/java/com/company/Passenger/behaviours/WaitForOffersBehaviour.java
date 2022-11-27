package com.company.Passenger.behaviours;

import java.util.Date;
import java.util.Vector;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import com.company.Common.*;


class WaitForOffersBehaviour extends OneShotBehaviour {

	private Logger logger;
	private Agent agent;
	private AID[] companies;
	private MessageTemplate template;

	public WaitForOffersBehaviour(Agent agent, Logger logger, AID[] companies, MessageTemplate template) {
		super(agent);
		this.agent = agent;	
		this.logger = logger;	
		this.companies = companies;
		this.template = template;
	}

	public void action() {
		// Receive all proposals/refusals from companies.
		ACLMessage reply = myAgent.receive(this.template);

        Vector<Offer> offers = new Vector<Offer>();
		if (reply != null) {
			if (reply.getPerformative() == ACLMessage.PROPOSE) {
				offers.add(new Offer(reply.getContent(), reply.getSender()));
			}
			if (offers.size() >= this.companies.length) {
				this.agent.addBehaviour(new AcceptBestOfferBehaviour(this.agent, this.logger, offers));
				return;
			}
		}
		else {
			block();
		}
	} 

}
