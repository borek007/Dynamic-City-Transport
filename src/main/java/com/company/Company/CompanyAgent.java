package com.company.Company;

import com.company.Common.Company;
import com.company.Common.Logger;
import com.company.Vehicle.VehicleAgent;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.util.leap.Set;

import java.time.LocalDateTime;

public class CompanyAgent extends Agent {

    //final private Set<Vehicle> vehicleList = new HashSet<Vehicle>();

    private Company myCompany;

    private CompanyAgent agent = this;

    protected Logger logger;

    public Company getMyCompany() {
        return myCompany;
    }

    public void setMyCompany(Company myCompany) {
        this.myCompany = myCompany;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public CompanyAgent(Company company)
    {
        this.myCompany = company;
    }

    DFAgentDescription df = new DFAgentDescription();

    @Override
    protected void setup() {
        super.setup();
        logger.log("Company is ready");
        myCompany.setAgentAID(this.getAID());

        ServiceDescription sd = new ServiceDescription();
        sd.setType("Company-DISCOVERY");
        sd.setName(agent.getName());


        df.addServices(sd);

        try {
            DFService.register(this, df);
            logger.log("Registering to DF agent...");
        } catch (FIPAException e) {
            logger.log("Couldn't register to DF agent!");
        }



        //addBehaviour(new informPlaceBehaviour());

    }



    public void informSchedule(){

    }

    public void informPlace()
    {

    }
    protected void takeDown() {
        try {
            DFService.deregister(this, df);
        } catch (FIPAException e) {
            e.printStackTrace();
        }
    }

}
