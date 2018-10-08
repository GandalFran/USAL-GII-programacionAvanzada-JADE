package controller;

import controller.communicationController.Agent;
import controller.communicationController.Object;
import controller.communicationController.String;

public interface Controller<T>{
	
	bool clusterize(List<T>toCluster, List<Cluster<T>>clusters);
		
	List<T> getAllElements();
	List<Cluster<T>> getAllClusters();
	
	bool importElements( String filePath );
	bool exportElements( String filePath );
	
	bool importClusters( String filePath );
	bool exportClusters( String filePath );
	
	
	bool sendMessage(Agent agent, String type, Object objeto, String ontology);
	Object receiveMessage(Agent agent, String ontology);
}
