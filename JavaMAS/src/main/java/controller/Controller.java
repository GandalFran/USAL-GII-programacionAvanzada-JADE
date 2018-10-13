package controller;

import java.util.List;

import POJO.ClusterImpl;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public interface Controller<T>{
	
	boolean clusterize();
		
	List<T> getAllElements();
	List<ClusterImpl> getAllClusters();
	
	boolean importElements( String filePath);
	boolean exportElements( String filePath);
	
	boolean importClusters( String filePath);
	boolean exportClusters( String filePath);
	
	boolean sendMessage(Agent agent, String type, Object objeto, String ontology );
	ACLMessage receiveMessage( Agent agent, String ontology);
}
