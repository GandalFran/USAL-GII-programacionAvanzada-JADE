package agent.behaviour;

import java.util.Scanner;

import controller.projectController.ProjectControllerImpl;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;

public class ProjectClusterBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;

	private String elementsFilePath;
	private String clustersFilePath;
	private ProjectControllerImpl controller;

	public ProjectClusterBehaviour(String elementsFilePath, String clustersFilePath) {
		this.elementsFilePath = elementsFilePath;
		this.clustersFilePath = clustersFilePath;
		this.controller = new ProjectControllerImpl();
	}
	
	
	@Override
	public void action() {
		boolean result;
		ACLMessage msg = null;
		
		System.out.println("Pulsa enter");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		//msg = controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.INFORM);
		controller.sendMessage(myAgent, Constants.DPCA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.CFP);
/*
		result = controller.importElements(elementsFilePath);
		if(result == true )
			result = controller.clusterize();
		if(result == true)
			result = controller.exportClusters(clustersFilePath);
		*/
		controller.sendMessage(myAgent, Constants.SPMA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.REQUEST);
		controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.INFORM);
		controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.CONFIRM);
	}
}
