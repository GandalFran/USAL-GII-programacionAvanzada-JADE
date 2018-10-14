package controller.projectController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import POJO.Project;
import POJO.ProjectCluster;
import POJO.StudentCluster;
import controller.ClusterizationController;
import controller.CommunicationController;
import controller.Controller;
import controller.MappingController;
import controller.IOServices.ListFileDAO;
import controller.IOServices.MapFileDAO;
import controller.communicationServices.JadeCommunicationControllerImpl;
import controller.projectController.IOServicesImpl.JsonProjectListFileDAOImpl;
import controller.projectController.IOServicesImpl.JsonProjectMapFileDAOImpl;
import controller.projectController.IOServicesImpl.SerialProjectClusterListFileDAOImpl;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import model.Model;
import model.ModelImpl;

public class ProjectControllerImpl implements Controller<Project,ProjectCluster,StudentCluster>{

	private Model<Project,ProjectCluster> model;
	private ListFileDAO<Project> elementDAO;
	private ListFileDAO<ProjectCluster> clusterDAO;
	private MapFileDAO<StudentCluster,Project> mapDAO;
	private MappingController<ProjectCluster,Project> mappingController;
	private ClusterizationController<Project,ProjectCluster> clusterController;
	private CommunicationController communicationController;
	
	
	public ProjectControllerImpl() {
		model = new ModelImpl<Project,ProjectCluster>();
		elementDAO = new JsonProjectListFileDAOImpl();
		clusterDAO = new SerialProjectClusterListFileDAOImpl();
		mapDAO = new JsonProjectMapFileDAOImpl();
		clusterController = new DBSCANProjectClusterizationControllerImpl();
		mappingController = new StudentProjectMappingControllerImpl();
		communicationController = new JadeCommunicationControllerImpl();
	}
	
	@Override
	public boolean clusterize() {
		boolean result;
		List<ProjectCluster> clusters = new ArrayList<>();
		
		result = clusterController.clusterize(model.getAllElements(), clusters);
		if(result)
			model.addAllClusters(clusters);
		return result;
	}

	@Override
	public List<Project> getAllElements() {
		return model.getAllElements();
	}

	@Override
	public List<ProjectCluster> getAllClusters() {
		return model.getAllClusters();
	}

	@Override
	public boolean importElements(String filePath) {
		boolean result;
		List<Project> toFill = new ArrayList<>();
		
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
		List<ProjectCluster> toFill = new ArrayList<>();
		
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
	public boolean sendMessage(Agent agent, String type, Object objeto, String ontology, int performative) {
		return communicationController.sendMessage(agent,type,objeto,ontology, performative);
	}	
	
	@Override
	public ACLMessage receiveMessage(Agent agent, String ontology) {
		return communicationController.receiveMessageBlocking(agent,ontology);
	}
	
	@Override
	public ACLMessage receiveMessage(Agent agent, String ontology, int performative) {
		return communicationController.receiveMessageBlocking(agent,ontology, performative);
	}

	@Override
	public boolean doMappingAndExport(String filePath) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean doMappingAndExport(String filePath, List<StudentCluster> studentClusters) {
		boolean result;
		Map<StudentCluster,Project> toFill = new HashMap<StudentCluster,Project>();
		
		result = mappingController.doMapping(studentClusters, model.getAllClusters(), toFill);
		if(result)
			mapDAO.exportMultipleObject(filePath, toFill);
		return result;
	}

}
