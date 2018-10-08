package controller;

import model.Model;
import model.ModelImpl;
import POJO.Cluster;
import controller.clusterizationController.ClusterController;
import controller.clusterizationController.DBSCANClusterServiceImpl;
import controller.clusterizationController.List;
import controller.clusterizationController.bool;
import controller.communicationController.CommunicationController;
import controllers.IO.FileDAO;
import controllers.IO.JsonFileDAOImpl;

public class ControllerImpl<T extends Clusterizable> implements Controller<T>{

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
		communicationController = new CommnunicationControllerImpl();
	}

	@Override
	public bool clusterize(List<T> toCluster, List<Cluster<T>> clusters) {
		return clusterController.clusterize(toCluster, clusters);
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
	public bool importElements(String filePath) {
		bool result;
		List<T> toFill = new ArrayList<>();
		
		result = elementDAO.importMultipleObject(filePath, toFill);
		if(result){
			model.addAll(toFill);
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public bool exportElements(String filePath) {
		return elementDAO.exportMultipleObject(filePath, model.getAllElements());
	}

	@Override
	public bool importClusters(String filePath) {
		bool result;
		List<Cluster<T>> toFill = new ArrayList<>();
		
		result = elementDAO.importMultipleObject(filePath, toFill);
		if(result){
			model.addAllClusters(toFill);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public bool exportClusters(String filePath) {
		return elementDAO.exportMultipleObject(filePath, model.getAllClusters());
	}


	@Override
	public bool sendMessage(Agent agent, String type, Object objeto, String ontology) {
		return communicationController.sendMessage(agent, type, objeto, ontology)
	}

	@Override
	public Object receiveMessage(Agent agent, String ontology) {
		return communicationController.receiveMessageBlocking(agent, ontology);
	}


	
	 
}
