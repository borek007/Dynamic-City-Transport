package com.company.Common;

import java.util.concurrent.ThreadLocalRandom;

public class Map {
	// Distance matrix needs to be updated in case changing city amount.
	private static final Integer cityCount = 10;
	// Symetric matrix with random numbers 1-9 to represent distances.
	private static final Integer [][] distances = new Integer[][] {
		{0, 8, 8, 9, 1, 3, 3, 4, 4, 4},
		{8, 0, 8, 5, 1, 1, 8, 1, 6, 1},
		{8, 8, 0, 5, 8, 6, 1, 5, 1, 6},
		{9, 5, 5, 0, 3, 9, 1, 4, 4, 1},
		{1, 1, 8, 3, 0, 5, 9, 9, 4, 8},
		{3, 1, 6, 9, 5, 0, 7, 6, 2, 6},
		{3, 8, 1, 1, 9, 7, 0, 4, 4, 2},
		{4, 1, 5, 4, 9, 6, 4, 0, 7, 8},
		{4, 6, 1, 4, 4, 2, 4, 7, 0, 6},
		{4, 1, 6, 1, 8, 6, 2, 8, 6, 0},
    };

	// Get distance between two cities in terms of time of travel
	// between them. Accepts city ID and returns -1 in case cities are
	// invalid.
    public static Integer getDistance(Integer from, Integer to) {
		if (!isValid(from) || !isValid(to)) {
			return -1;
		}
		return distances[from][to];
	}

	private static boolean isValid(Integer cityId) {
		if (cityId < 0 || cityId >= cityCount) {
			return false;
		}
		return true;
	}

	// This method could be used to get random location when initializing
	// Vehicles and Passengers, and setting passenger targets.
	// Return a city identifier (Integer).
	public static Integer getRandomCity(){
		return ThreadLocalRandom.current().nextInt(0, cityCount);
	}

	// Get random target city different then starting point 'from'.
	public static Integer getRandomTargetCity(Integer from){
		Integer curr = from;
		while (curr == from) {
			curr = ThreadLocalRandom.current().nextInt(0, cityCount);
		}
		return curr;

	}
}
