package com.company.Passenger;

import com.company.Common.*;
import com.company.Passenger.behaviours.SetDestinationBehaviour;

import jade.core.AID;
import jade.core.Agent;
import java.time.LocalDateTime;
import java.util.Vector;

public class PassengerAgent extends Agent {

	protected void setup() {
		super.setup();
		Logger l = new Logger(this.getName());
        l.log("passenger initialized");
		Integer currentCityID = Map.getRandomCity();

		// All the things are done in a chain of OneShotBehaviours.
		// Each behaviour will trigger the next one.
		addBehaviour(new SetDestinationBehaviour(this, l, currentCityID));
		// Passenger behavoiour:
		// 1) DONE Set up random target city.
		// 2) DONE Request a list of companies.
		// 3) DONE Make Order CFP to all of the companies.
		// 4) DONE Have a behaviour waiting for their responses
		// 5) DONE Store the data and choose appropriate one (add Strategy interface and class).
		// 7) Get picked up by a vehicle (get message saying that your are picked up).
		// 8) Get back to 1)
	}

}
