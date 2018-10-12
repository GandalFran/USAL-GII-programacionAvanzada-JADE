package controller.controllerImpl;

import model.Model;
import model.ModelImpl;
import utils.Constants;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.ml.clustering.Clusterable;

import POJO.ClusterImpl;
import POJO.Project;
import POJO.Student;
import controller.Controller;
import controller.IOServices.FileDAO;
import controller.IOServices.MapFileDAO;
import controller.IOServices.IOServicesImpl.JsonFileDAOImpl;
import controller.IOServices.IOServicesImpl.JsonMapFileDAOImpl;
import controller.IOServices.IOServicesImpl.SerializationFileDAOImpl;
import controller.clusterizationController.ClusterController;
import controller.communicationController.CommunicationController;
import controller.mappingController.MappingController;
import jade.core.Agent;
import java.util.HashMap;

public class ControllerImpl<T extends Clusterable> implements Controller<T>, MappingController{

	private Model<T> model;
	private FileDAO<T> elementDAO;
	private SerializationFileDAOImpl clusterDAO;
	private ClusterController<T> clusterController;
	private CommunicationController communicationController;
	
	public ControllerImpl(){
		model = new ModelImpl<T>();
		elementDAO = new JsonFileDAOImpl<T>();
		clusterDAO = new SerializationFileDAOImpl();
		clusterController = new DBSCANClusterizationControllermpl<T>();
		communicationController = new JadeCommunicationControllerImpl();
	}

	@Override
	public boolean clusterize() {
		boolean result;
		List<ClusterImpl> clusters = new ArrayList<>();
		
		result = clusterController.clusterize(this.model.getAllElements(), clusters);
		if(result == true) {
			this.model.addAllClusters(clusters);
		}
		
		return result;
	}

	@Override
	public List<T> getAllElements() {
		return model.getAllElements();
	}

	@Override
	public List<ClusterImpl> getAllClusters() {
		return model.getAllClusters();
	}

	@Override
	public boolean importElements(String filePath) {
		boolean result;
		List<T> toFill = new ArrayList<>();
		
		result = elementDAO.importMultipleObject(filePath, toFill);
		if(result){
			model.addAllElements(toFill);
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean exportElements(String filePath) {
		return elementDAO.exportMultipleObject(filePath, model.getAllElements());
	}

	@Override
	public boolean importClusters(String filePath) {
		boolean result;
		List<ClusterImpl> toFill = new ArrayList<>();
		
		result = clusterDAO.importMultipleObject(filePath, toFill);
		if(result){
			model.addAllClusters(toFill);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean exportClusters(String filePath) { 
		return clusterDAO.exportMultipleObject(filePath, model.getAllClusters());
	}


	@Override
	public boolean sendMessage(String agentName, Object content) {
		return true;
		//return communicationController.sendMessage();
	}

	@Override
	public Object receiveMessage( ) {
		return true;
		//return communicationController.receiveMessageBlocking();
	}

	@Override
	public boolean doMappingAndExport(String filePath, List<ClusterImpl> studentClusterList, List<Student> helpersList) {
		/*Map<Cluster<Student>,Student> mappingResult = new HashMap<Cluster<Student>,Student>();
		MapFileDAO<Cluster<Student>, Student> mapsDAO = new JsonMapFileDAOImpl<Cluster<Student>, Student>();
		
		for (Cluster<Student> studentCluster: studentClusterList) {
			List<Student> studentList = studentCluster.getClusterElements();
			Integer[] averageSkills = studentList.get(0).getClusterParametersArray();
			
			// The average skills of the students are calculated
			for (int i = 1; i < studentList.size(); i++)
				for (int j = 0; j < averageSkills.length; j++)
					averageSkills[j] += studentList.get(i).getClusterParametersArray()[j];
			
			for (int i = 0; i < averageSkills.length; i++)
				averageSkills[i] /= studentList.size();
			
			// you are looking for a helper who has slightly better skills
			for (Student helper: helpersList) {
				Integer[] helperSkills = helper.getClusterParametersArray();
				boolean flag = true;
				
				for (int i = 0; i < helperSkills.length; i++) {
					int difference = helperSkills[i].compareTo(averageSkills[i]);
					
					if (difference < Constants.DELTA || difference > 2*Constants.DELTA) {
						flag = false;
						break;
					}
				}
				
				// Adding the match.
				if(flag) {
					mappingResult.put(studentCluster, helper);
					break;
				}
			}
		}
		
		
		mapsDAO.exportMultipleObject(filePath, mappingResult);
*/
		return true;
	}

	@Override
	public boolean doMappingAndExport(String filePath, List<ClusterImpl>studentClusterList, ArrayList<ClusterImpl> projectClusterList) {
	/*	Map<Cluster<Student>,Project> mappingResult = new HashMap<Cluster<Student>,Project>();
		MapFileDAO<Cluster<Student>, Project> mapsDAO = new JsonMapFileDAOImpl<Cluster<Student>, Project>();
		
		for (Cluster<Student> studentCluster: studentClusterList) {
			List<Student> studentList = studentCluster.getClusterElements();
			Integer[] averageSkills = studentList.get(0).getClusterParametersArray();
			
			// The average skills of the students are calculated
			for (int i = 1; i < studentList.size(); i++)
				for (int j = 0; j < averageSkills.length; j++)
					averageSkills[j] += studentList.get(i).getClusterParametersArray()[j];
			
			for (int i = 0; i < averageSkills.length; i++)
				averageSkills[i] /= studentList.size();
			
			// We are looking for a projects' cluster that have skills similar 
			// to the average of the students' skills.
			for (Cluster<Project> projectCluster: projectClusterList) {
				if (Constants.EPSILON > Utils.euclidianDistance(projectCluster.getClusterElements().get(0).getClusterParametersArray(), averageSkills)) {
					boolean flag = true;
					
					// We are looking for a project that is suitable for student cluster.
					for (Project project: projectCluster.getClusterElements()) {
						Integer[] projectSkills = project.getClusterParametersArray();
						flag = true;
						
						for (int i = 0; i < projectSkills.length; i++) {
							int difference = projectSkills[i].compareTo(averageSkills[i]);
							
							if (difference < 0 || difference > Constants.DELTA) {
								flag = false;
								break;
							}
						}
						
						// Adding the match.
						if(flag) {
							mappingResult.put(studentCluster, project);
							break;
						}
					}
					
					// If not found a suitable project, it will match with the first project of the project cluster.
					if (!flag)
						mappingResult.put(studentCluster, projectCluster.getClusterElements().get(0));
					
					break;
				}
			}	
		}
		
		mapsDAO.exportMultipleObject(filePath, mappingResult);
*/
		return true;
	}




	
	 
}
