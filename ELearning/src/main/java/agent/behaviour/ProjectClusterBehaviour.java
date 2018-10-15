package agent.behaviour;


import controller.projectController.ProjectControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;

public class ProjectClusterBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;

	private ProjectControllerImpl controller;

	public ProjectClusterBehaviour() {
		this.controller = new ProjectControllerImpl();
	}
	
	
	@Override
	public void action() {
		boolean result;

		controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.REQUEST);
		controller.sendMessage(myAgent, Constants.DPCA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.CONFIRM);

		controller.clear();
		
		result = controller.importElements(Constants.PROJECTS_FILE_PATH);
		if(result == true )
			result = controller.clusterize();
		if(result == true)
			result = controller.exportClusters(Constants.PROJECT_CLUSTERS_FILE_PATH);
		
		controller.sendMessage(myAgent, Constants.SPMA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.REQUEST);
		controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.CONFIRM);
	}
}
