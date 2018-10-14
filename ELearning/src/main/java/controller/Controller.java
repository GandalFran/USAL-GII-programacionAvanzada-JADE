package controller;

import java.util.List;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public interface Controller<E,C,M>{
	
	boolean clusterize();
		
	List<E> getAllElements();
	List<C> getAllClusters();
	
	boolean importElements( String filePath);
	boolean exportElements( String filePath);
	
	boolean importClusters( String filePath);
	boolean exportClusters( String filePath);
	
	boolean sendMessage(Agent agent, String type, Object objeto, String ontology, int performative );
	public ACLMessage receiveMessage(Agent agent, String ontology);
	ACLMessage receiveMessage( Agent agent, String ontology, int performative);

	boolean doMappingAndExport(String filePath);
	boolean doMappingAndExport(String filePath, List<M>toMap);
}
