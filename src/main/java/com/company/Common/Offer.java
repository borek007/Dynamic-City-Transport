package com.company.Common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jade.core.AID;

public class Offer {


	public Integer price;
	public Integer destinationAt; // Time at which destination location will be reached.
	public AID sender; // Sender of the offer
	public String json;

	private Pattern p = Pattern.compile("{price:(\\d+),destinationAt:(\\d+)}");

	public Offer(String json, AID sender){
		this.json = json;
		this.sender = sender;
		// Now create matcher object.
		Matcher matches = p.matcher(json);
		if (matches.find()) {
			this.price = Integer.parseInt(matches.group(0));
			this.destinationAt = Integer.parseInt(matches.group(1));
		} else {
			System.out.print("ERROR: could not parse Offer: " + json);
		}

	}

	public Offer(Integer price, Integer destinationAt){
		this.price = price;
		this.destinationAt = destinationAt;
		this.json = "{price:" + Integer.toString(price) + ",destinationAt:" + Integer.toString(destinationAt) + "}";

	}
}
