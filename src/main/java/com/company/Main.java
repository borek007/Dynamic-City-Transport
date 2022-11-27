package com.company;

import com.company.Common.Map;

public class Main {
	
    public static void main(String[] args) {
		// TODO: Delete this, this just shows how you could use a Map.
        // We should somehow trigger the whole system from this function instead.
		Integer randomCity1 = Map.getRandomCity();
		Integer randomCity2 = Map.getRandomCity();
		Integer distance = Map.getDistance(randomCity1, randomCity2);
		System.out.printf("Distance from city %d to city %d is %d\n", randomCity1, randomCity2, distance);
    }
}
