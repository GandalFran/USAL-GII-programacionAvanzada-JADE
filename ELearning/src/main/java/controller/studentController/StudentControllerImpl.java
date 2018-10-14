package controller.studentController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import POJO.Student;
import POJO.StudentCluster;
import controller.ClusterizationController;
import controller.CommunicationController;
import controller.Controller;
import controller.JadeCommunicationControllerImpl;
import controller.MappingController;
import controller.IOServices.ListFileDAO;
import controller.IOServices.MapFileDAO;
import controller.studentController.IOServiceImpl.JsonStudentListFileDAOImpl;
import controller.studentController.IOServiceImpl.JsonStudentMapFileDAOImpl;
import controller.studentController.IOServiceImpl.SerialStudentClusterListFileDAOImpl;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import model.Model;
import model.ModelImpl;

public class StudentControllerImpl implements Controller<Student,StudentCluster,StudentCluster>{
	
	private Model<Student,StudentCluster> model;
	private ListFileDAO<Student> elementDAO;
	private ListFileDAO<StudentCluster> clusterDAO;
	private MapFileDAO<StudentCluster,Student> mapDAO;
	private MappingController<Student,Student> mappingController;
	private ClusterizationController<Student,StudentCluster> clusterController;
	private CommunicationController communicationController;
	
	
	public StudentControllerImpl() {
		model = new ModelImpl<Student,StudentCluster>();
		elementDAO = new JsonStudentListFileDAOImpl();
		clusterDAO = new SerialStudentClusterListFileDAOImpl();
		mapDAO = new JsonStudentMapFileDAOImpl();
		clusterController = new DBSCANStudentClusterizationControllerImpl();
		mappingController = new StudentStudentMappingControllerImpl();
		communicationController = new JadeCommunicationControllerImpl();
	}
	@Override
	public boolean clusterize() {
		boolean result;
		List<StudentCluster> clusters = new ArrayList<>();
		
		result = clusterController.clusterize(model.getAllElements(), clusters);
		if(result)
			model.addAllClusters(clusters);
		return result;
	}

	@Override
	public List<Student> getAllElements() {
		return model.getAllElements();
	}

	@Override
	public List<StudentCluster> getAllClusters() {
		return model.getAllClusters();
	}

	@Override
	public boolean importElements(String filePath) {
		boolean result;
		List<Student> toFill = new ArrayList<>();
		
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
		List<StudentCluster> toFill = new ArrayList<>();
		
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
		return communicationController.sendMessage(agent,type,objeto,ontology);
	}

	@Override
	public ACLMessage receiveMessage(Agent agent, String ontology) {
		return communicationController.receiveMessageBlocking(agent,ontology);
	}

	@Override
	public boolean doMappingAndExport(String filePath) {
		boolean result;
		Map<StudentCluster,Student> toFill = new HashMap<StudentCluster,Student>();
		
		result = mappingController.doMapping(model.getAllClusters(), model.getAllElements(), toFill);
		if(result)
			mapDAO.exportMultipleObject(filePath, toFill);
		return result;
	}
	
	@Override
	public boolean doMappingAndExport(String filePath, List<StudentCluster> toMap) {
		throw new UnsupportedOperationException();
	}


}
