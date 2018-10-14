package agent.behaviour;

import java.util.Scanner;

import controller.studentController.StudentControllerImpl;
import jade.core.AID;
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
			//QUITAR ESTO
			block();
			boolean result;
			ACLMessage msg = null;

			System.out.println("Pulsa enter");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			
			//msg = controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.REQUEST);
			controller.sendMessage(myAgent, Constants.DSCA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.CONFIRM);
			controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.INFORM);

			/*result = controller.importElements(elementsFilePath);
			if(result == true )
				result = controller.clusterize();
			if(result == true)
				result = controller.exportClusters(clustersFilePath);
			*/
			controller.sendMessage(myAgent, Constants.SSMA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.REQUEST);
			controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.INFORM);
			controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.CONFIRM);
		}
	}