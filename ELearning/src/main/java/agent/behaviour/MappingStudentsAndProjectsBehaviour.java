package agent.behaviour;

import controller.projectController.ProjectControllerImpl;
import controller.studentController.StudentControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;

public class MappingStudentsAndProjectsBehaviour extends CyclicBehaviour{
	
	private static final long serialVersionUID = 1L;

	private StudentControllerImpl studentController = new StudentControllerImpl();
	private ProjectControllerImpl projectController = new ProjectControllerImpl();
	
	@Override
	public void action() {
		boolean result;
		
		ACLMessage msg = studentController.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.REQUEST);
		studentController.sendMessage(myAgent, msg.getSender().getLocalName(), null, Constants.ONTOLY_NAME, ACLMessage.CONFIRM);

		studentController.clear();
		projectController.clear();
		
		result = projectController.importClusters(Constants.PROJECT_CLUSTERS_FILE_PATH);
		if(false != result )
			result = studentController.importClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);
		if(false != result )
			result =  projectController.doMappingAndExport(Constants.STUDENT_PROJECTS_FILE_PATH,studentController.getAllClusters());
		
	}

}
