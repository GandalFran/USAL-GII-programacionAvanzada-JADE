package behaviourImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import POJO.Cluster;
import POJO.Project;
import POJO.Student;
import controller.Controller;
import controller.IOServices.MapFileDAO;
import controller.IOServices.IOServicesImpl.JsonMapFileDAOImpl;
import controller.controllerImpl.ControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import utils.Constants;

public class MappingStudentsAndProjectsBehaviour extends CyclicBehaviour{

	private Controller<Student> studentController = new ControllerImpl<Student>();
	private ControllerImpl<Project> projectController = new ControllerImpl<Project>();
	private MapFileDAO<Cluster<Student>, Project> DAO = new JsonMapFileDAOImpl<Cluster<Student>, Project>();
	private static final long serialVersionUID = 1L;
	
	@Override
	public void action() {
		boolean result;
		
		//reciveB( SCA and PCA)

		result = projectController.importClusters(Constants.PROJECTS_FILE_PATH);
		if(false != result )
			result = studentController.importClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);
		if(false != result )
			result =  projectController.doMappingAndExport(Constants.STUDENT_PROJECTS_FILE_PATH,studentController.getAllClusters(),(ArrayList<Cluster<Project>>)projectController.getAllClusters());
		
		
		if(result ) {
			//send(SCA and PCA) confirmation
		}else {
			//send(SCA and PCA) trouble
		}
		
	}

}
