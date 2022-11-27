package com.company.Company.behaviours;

import com.company.Common.Logger;
import com.company.Common.Map;
import com.company.Company.CompanyAgent;
import jade.core.behaviours.CyclicBehaviour;


public class FindingAvailableVehiclesBehaviour extends CyclicBehaviour {

    int curentCity;
    int DestinationCity;
    boolean status;
    // List<Vehicle> vehicleList;

    private CompanyAgent myCompanyAgent;

    protected Logger logger;

    public FindingAvailableVehiclesBehaviour(CompanyAgent a) {
        super(a);
        this.myCompanyAgent = a;
    }

    @Override
    public void action() {

    }

    public void calculateDistance()
    {
        Map.getDistance(curentCity,DestinationCity);
    }


    public static int findMinDiff(int [] a, int x, int y) {
        //previous index and min distance
        int next = -1,curr = -1, min_dist = Integer.MAX_VALUE;

        for(int i=0 ; i<a.length ; i++)
        {
            if(a[i]==x)
            {
                curr = i;
                if(next != -1) {
                    min_dist = Math.min(min_dist, Math.abs(curr-next));
                }
            }
            else if(a[i] == y){
                next = i;
                if(curr != -1){
                    min_dist = Math.min(min_dist, Math.abs(curr-next));
                }
            }

        }

        if(min_dist==Integer.MAX_VALUE)
            return -1;

        return min_dist;
    }

}
