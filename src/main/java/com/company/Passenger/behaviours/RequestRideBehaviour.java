package com.company.Passenger.behaviours;

import java.util.Date;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import com.company.Common.*;


class RequestRideBehaviour extends OneShotBehaviour {

	private Logger logger;
	private Agent agent;
	private Integer from;
	private Integer to;
	private AID[] companies;

	public RequestRideBehaviour(Agent agent, Logger logger, Integer from, Integer to, AID[] companies) {
		super(agent);
		this.agent = agent;	
		this.logger = logger;	
		this.from = from;	
		this.to = to;	
		this.companies = companies;
	}

	public void action() {
		this.logger.log("send requests to companies");
  		ACLMessage msg = new ACLMessage(ACLMessage.CFP);
  		for (int i = 0; i < this.companies.length; ++i) {
  			msg.addReceiver(companies[i]);
  		}
		msg.setPerformative(ACLMessage.CFP);
		msg.setOntology(Common.REQUEST_RIDE_ONTOLOGY);
		// Wait 5s for getting the replies.
		msg.setReplyByDate(new Date(System.currentTimeMillis() + 5000));
		msg.setContent(new RequestRideMessage(this.from, this.to).json);
		String conversationID = "conversation-" + System.currentTimeMillis();
		msg.setConversationId(conversationID);
		this.logger.logSend(msg);
		this.agent.send(msg);

		// Prepare template for the next step - receiving.
		MessageTemplate mt = MessageTemplate.and(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.PROPOSE),
															 MessageTemplate.MatchOntology(Common.SEND_OFFER_ONTOLOGY)),
												MessageTemplate.MatchConversationId(conversationID));
		this.agent.addBehaviour(new WaitForOffersBehaviour(this.agent, this.logger, this.companies, mt));

	} 

}
