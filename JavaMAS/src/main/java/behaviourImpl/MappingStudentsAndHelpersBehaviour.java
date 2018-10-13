package behaviourImpl;

import POJO.Student;
import controller.Controller;
import controller.IOServices.MapFileDAO;
import controller.IOServices.IOServicesImpl.JsonMapFileDAOImpl;
import controller.controllerImpl.ControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.List;
import java.util.Map;
import utils.Constants;

public class MappingStudentsAndHelpersBehaviour extends CyclicBehaviour{

	private ControllerImpl<Student> studentController = new ControllerImpl<Student>();
	
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
			result = studentController.doMappingAndExport(Constants.STUDENT_HELPERS_FILE_PATH,studentController.getAllClusters(),studentController.getAllElements());
		
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