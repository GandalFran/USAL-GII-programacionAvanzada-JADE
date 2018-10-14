package agent.behaviour;

import controller.studentController.StudentControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import utils.Constants;

public class MappingStudentsAndHelpersBehaviour extends CyclicBehaviour{

	private StudentControllerImpl studentController = new StudentControllerImpl();
	private static final long serialVersionUID = 1L;
	
	@Override
	public void action() {
		boolean result;
		
		ACLMessage msg=studentController.receiveMessage(myAgent,Constants.ONTOLY_NAME);
		
		if(msg.getContent().equals("fallo")) {
			System.out.println("Recibido un mensaje de fallo\n");
		}

		result = studentController.importElements(Constants.STUDENTS_FILE_PATH);
		if(false != result )
			result = studentController.importClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);
		if(false != result )
			result = studentController.doMappingAndExport(Constants.STUDENT_HELPERS_FILE_PATH);
		
		if(result) {
			if(!studentController.sendMessage(myAgent,Constants.SCA_SERVICE_NAME,"bien",Constants.ONTOLY_NAME)) {
				System.out.println("Error al enviar mensaje a SCA");
			}
		}else {
			if(!studentController.sendMessage(myAgent,Constants.SCA_SERVICE_NAME,"fallo",Constants.ONTOLY_NAME)) {
				System.out.println("Error al enviar mensaje a SCA");
			}
		}
			
	}

}