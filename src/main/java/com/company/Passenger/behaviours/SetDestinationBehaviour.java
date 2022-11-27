package com.company.Passenger.behaviours;

import com.company.Common.Map;
import com.company.Common.Logger;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;


public class SetDestinationBehaviour extends OneShotBehaviour {

	int from;
	Logger logger;
	Agent agent;

	public SetDestinationBehaviour(Agent agent, Logger logger, Integer from) {
		super(agent);
		this.agent = agent;
		this.logger = logger;
		this.from = from;
	}

	public void action() {
		Integer to = Map.getRandomTargetCity(this.from);
		this.logger.log("want to travel from city " + Integer.toString(this.from) + " to city " + Integer.toString(to));
	    myAgent.addBehaviour(new GetCompaniesBehaviour(this.agent, this.logger, this.from, to));
	} 

}
