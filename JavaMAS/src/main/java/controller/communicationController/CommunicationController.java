package controller.communicationController;

public interface CommunicationController {
	public void sendMessage(Agent agent, String type, Object objeto, String ontology);
	public Object receiveMessageBlocking(Agent agent, String ontology);
	public Object receiveMessageNotBlocking(Agent agent, String ontology);
}
