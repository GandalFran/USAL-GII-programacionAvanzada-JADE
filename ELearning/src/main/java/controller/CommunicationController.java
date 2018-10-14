package controller;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public interface CommunicationController {
	public boolean sendMessage(Agent agent, String type, Object objeto, String ontology);
	public ACLMessage receiveMessageBlocking(Agent agent, String ontology);
}
