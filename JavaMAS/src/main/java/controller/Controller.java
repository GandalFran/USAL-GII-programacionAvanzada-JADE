package controller;

import java.util.List;

import POJO.ClusterImpl;

public interface Controller<T>{
	
	boolean clusterize();
		
	List<T> getAllElements();
	List<ClusterImpl> getAllClusters();
	
	boolean importElements( String filePath);
	boolean exportElements( String filePath);
	
	boolean importClusters( String filePath);
	boolean exportClusters( String filePath);
	
	boolean sendMessage(String agentName, Object content);
	Object receiveMessage();
}
