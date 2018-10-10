package controller;

import model.Model;
import model.ModelImpl;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import POJO.Cluster;
import POJO.Project;
import POJO.Student;
import controller.clusterizationController.ClusterController;
import controller.clusterizationController.DBSCANClusterServiceImpl;
import controller.communicationController.CommunicationController;
import controller.communicationController.JadeCommunicationControllerImpl;
import controllers.IO.FileDAO;
import controllers.IO.JsonFileDAOImpl;
import controllers.IO.MapFileDAO;
import controllers.IO.MapFileDAOImpl;
import jade.core.Agent;
import java.util.HashMap;

public class ControllerImpl<T extends Clusterizable> implements Controller<T>, MappingController{

	private Model<T> model;
	private FileDAO<T> elementDAO;
	private FileDAO<Cluster<T>> clusterDAO;
	private ClusterController<T> clusterController;
	private CommunicationController communicationController;
	
	public ControllerImpl(){
		model = new ModelImpl<T>();
		elementDAO = new JsonFileDAOImpl<T>();
		clusterDAO = new JsonFileDAOImpl<Cluster<T>>();
		clusterController = new DBSCANClusterServiceImpl<T>();
		communicationController = new JadeCommunicationControllerImpl();
	}

	@Override
	public boolean clusterize() {
		boolean result;
		List<Cluster<T>> clusters = new ArrayList<>();
		
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
	public List<Cluster<T>> getAllClusters() {
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
		List<Cluster<T>> toFill = new ArrayList<>();
		
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
	public boolean sendMessage(Agent agent, String type, Object objeto, String ontology) {
		return communicationController.sendMessage(agent, type, objeto, ontology);
	}

	@Override
	public Object receiveMessage(Agent agent, String ontology) {
		return communicationController.receiveMessageBlocking(agent, ontology);
	}

	@Override
	public boolean doMappingAndExport(String filePath, List<Cluster<Student>> studentClusterList, List<Student> helpersList) {
		Map<Cluster<Student>,Student> mappingResult = new HashMap<Cluster<Student>,Student>();
		MapFileDAO<Cluster<Student>, Student> mapsDAO = new MapFileDAOImpl<Cluster<Student>, Student>();
		
		//Do algorithm
		
		mapsDAO.exportMultipleObject(filePath, mappingResult);

		return true;
	}

	@Override
	public boolean doMappingAndExport(String filePath, List<Cluster<Student>> studentClusterList, ArrayList<Project> projectList) {
		Map<Cluster<Student>,Project> mappingResult = new HashMap<Cluster<Student>,Project>();
		MapFileDAO<Cluster<Student>, Project> mapsDAO = new MapFileDAOImpl<Cluster<Student>, Project>();
		
		//Do algorithm
		
		mapsDAO.exportMultipleObject(filePath, mappingResult);

		return true;
	}




	
	 
}
