package com.company.Company.behaviours;

import com.company.Common.Logger;
import com.company.Company.CompanyAgent;
import com.company.Passenger.PassengerAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AwaitPassengerBehaviour extends CyclicBehaviour {

    protected MessageTemplate messageTemplate;

    private CompanyAgent myCompanyAgent;

    protected Logger logger;

    public AwaitPassengerBehaviour(CompanyAgent a) {
        super(a);
        this.myCompanyAgent = a;
    }

    public void onMessageReceived(ACLMessage message) {
        logger.logReceived(message);

        var content = message.getContent();



    }

    public MessageTemplate messageTemplate(){
        return messageTemplate;
    }
    @Override
    public void action() {
        var message = myAgent.receive(messageTemplate());
        if (message != null){
            onMessageReceived(message);
        }
        else{
            block();
        }
    }


    public void prepareMessageTemplate() {

    }

}
