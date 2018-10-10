package behaviourImpl;

import POJO.Cluster;
import POJO.Student;
import controller.Controller;
import controller.ControllerImpl;
import controllers.IO.MapFileDAO;
import controllers.IO.MapFileDAOImpl;
import jade.core.behaviours.CyclicBehaviour;

import java.util.List;
import java.util.Map;
import utils.Constants;

public class MappingStudentsAndHelpersBehaviour extends CyclicBehaviour{

	private ControllerImpl<Student> studentController = new ControllerImpl<Student>();
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void action() {
		boolean result;
		
		//reciveB( SCA)

		result = studentController.importElements(Constants.STUDENTS_FILE_PATH);
		if(false != result )
			result = studentController.importClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);
		if(false != result )
			result = studentController.doMappingAndExport(Constants.STUDENT_HELPERS_FILE_PATH,studentController.getAllClusters(),studentController.getAllElements());
		
		if(result ) {
			//send(SCA) confirmation
		}else {
			//send(SCA) trouble
		}
			
	}

}