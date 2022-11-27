package com.company.Common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestRideMessage {

	public Integer from;
	public Integer to;
	public String json;

	private Pattern p = Pattern.compile("{from:(\\d+),to:(\\d+)}");

	public RequestRideMessage(String json){
		this.json = json;
		// Now create matcher object.
		Matcher matches = p.matcher(json);
		if (matches.find()) {
			this.from = Integer.parseInt(matches.group(0));
			this.to = Integer.parseInt(matches.group(1));
		} else {
			System.out.print("ERROR: could not parse RequestRideMessage: " + json);
		}

	}

	public RequestRideMessage(Integer from, Integer to){
		this.from = from;
		this.to = to;
		this.json = "{from:" + Integer.toString(from) + ",to:" + Integer.toString(to) + "}";

	}
}
