package com.company.Passenger.behaviours;

import com.company.Common.*;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
//import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.*;


class GetCompaniesBehaviour extends OneShotBehaviour {

	private Logger logger;
	private Agent agent;
	private Integer from;
	private Integer to;

	public GetCompaniesBehaviour(Agent agent, Logger logger, Integer from, Integer to) {
		super(agent);
		this.agent = agent;	
		this.logger = logger;	
		this.from = from;	
		this.to = to;	
	}

	public void action() {
		// Get a list of agents from DF:
		this.logger.log("search for companies");
		try {
			// Build the description used as template for the search
			DFAgentDescription template = new DFAgentDescription();
			ServiceDescription templateSd = new ServiceDescription();
			templateSd.setType(Common.SERVICE_TYPE_COMPANY);
			template.addServices(templateSd);
			DFAgentDescription[] results = DFService.search(this.agent, template);
			if (results.length > 0) {
				this.logger.log("found " + Integer.toString(results.length) + " companies");
				AID[] companies = new AID[results.length];
				for (int i = 0; i < results.length; ++i) {
					companies[i] = results[i].getName();
				}
				myAgent.addBehaviour(new RequestRideBehaviour(this.agent, this.logger, this.from, this.to, companies));
			}	
			else {
				this.logger.log("could not find any companies");
			}
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}

	} 

}
