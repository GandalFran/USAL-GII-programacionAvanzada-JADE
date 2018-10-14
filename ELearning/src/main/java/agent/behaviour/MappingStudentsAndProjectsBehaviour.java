package agent.behaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import POJO.Project;
import POJO.Student;
import controller.Controller;
import controller.IOServices.MapFileDAO;
import controller.projectController.ProjectControllerImpl;
import controller.studentController.StudentControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;

public class MappingStudentsAndProjectsBehaviour extends CyclicBehaviour{

	private StudentControllerImpl studentController = new StudentControllerImpl();
	private ProjectControllerImpl projectController = new ProjectControllerImpl();
	private static final long serialVersionUID = 1L;
	
	@Override
	public void action() {
		boolean result;
		
		ACLMessage msg = studentController.receiveMessage(myAgent,Constants.ONTOLY_NAME);
		
		if(msg.getContent().equals("fallo")) {
			System.out.println("Recibido un mensaje de fallo\n");
		}
		
		msg=projectController.receiveMessage(myAgent,Constants.ONTOLY_NAME);
		
		if(msg.getContent().equals("fallo")) {
			System.out.println("Recibido un mensaje de fallo\n");
		}

		result = projectController.importClusters(Constants.PROJECTS_FILE_PATH);
		if(false != result )
			result = studentController.importClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);
		if(false != result )
			result =  projectController.doMappingAndExport(Constants.STUDENT_PROJECTS_FILE_PATH,studentController.getAllClusters());
		
		
		if(result ) {
			if(!studentController.sendMessage(myAgent,Constants.SCA_SERVICE_NAME,"bien",Constants.ONTOLY_NAME)) {
				System.out.println("Error al enviar mensaje de bien");
			}
			if(!projectController.sendMessage(myAgent,Constants.PCA_SERVICE_NAME,"bien",Constants.ONTOLY_NAME)) {
				System.out.println("Error al enviar mensaje de bien");
			}
		}else {
			if(!studentController.sendMessage(myAgent,Constants.SCA_SERVICE_NAME,"fallo",Constants.ONTOLY_NAME)) {
				System.out.println("Error al enviar mensaje de mal");
			}
			if(!projectController.sendMessage(myAgent,Constants.PCA_SERVICE_NAME,"fallo",Constants.ONTOLY_NAME)) {
				System.out.println("Error al enviar mensaje de mal");
			}
		}
		
	}

}
