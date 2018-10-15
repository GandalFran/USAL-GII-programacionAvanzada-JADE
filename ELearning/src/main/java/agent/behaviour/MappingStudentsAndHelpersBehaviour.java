package agent.behaviour;

import controller.studentController.StudentControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import utils.Constants;

public class MappingStudentsAndHelpersBehaviour extends CyclicBehaviour{
	
	private static final long serialVersionUID = 1L;

	private StudentControllerImpl studentController = new StudentControllerImpl();
	
	@Override
	public void action() {
		boolean result;

		ACLMessage msg = studentController.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.REQUEST);
		studentController.sendMessage(myAgent, msg.getSender().getLocalName(), null, Constants.ONTOLY_NAME, ACLMessage.CONFIRM);

		studentController.clear();

		result = studentController.importElements(Constants.STUDENTS_FILE_PATH);
		if(false != result )
			result = studentController.importClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);
		if(false != result )
			result = studentController.doMappingAndExport(Constants.STUDENT_HELPERS_FILE_PATH);
			
	}

}