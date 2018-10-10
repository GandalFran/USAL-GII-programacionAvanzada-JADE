package controller.communicationController;

import jade.core.Agent;

public interface CommunicationController {
	public boolean sendMessage(Agent agent, String type, Object objeto, String ontology);
	public Object receiveMessageBlocking(Agent agent, String ontology);
	public Object receiveMessageNotBlocking(Agent agent, String ontology);
}
