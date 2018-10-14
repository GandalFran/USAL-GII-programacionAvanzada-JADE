package agent.behaviour;


import controller.studentController.StudentControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;

public class StudentClusterBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	
		private String elementsFilePath;
		private String clustersFilePath;
		private StudentControllerImpl controller;

		public StudentClusterBehaviour(String elementsFilePath, String clustersFilePath) {
			this.elementsFilePath = elementsFilePath;
			this.clustersFilePath = clustersFilePath;
			this.controller = new StudentControllerImpl();
		}
		
		
		@Override
		public void action() {
			boolean result;
			ACLMessage msg = null;

			do {
				msg = controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.REQUEST);
			}while(!msg.getSender().getLocalName().equals(Constants.DSCA_NAME));
			controller.sendMessage(myAgent, Constants.DSCA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.CONFIRM);

			result = controller.importElements(elementsFilePath);
			if(result == true )
				result = controller.clusterize();
			if(result == true)
				result = controller.exportClusters(clustersFilePath);
			
			controller.sendMessage(myAgent, Constants.SPMA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.REQUEST);
			do{
				msg = controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.CONFIRM);
			}while(!msg.getSender().getLocalName().equals(Constants.SPMA_NAME));
			
			controller.sendMessage(myAgent, Constants.SSMA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.REQUEST);
			do{
				msg = controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.CONFIRM);
			}while(!msg.getSender().getLocalName().equals(Constants.SSMA_NAME));
		}
	}