package model;

import java.util.List;

import POJO.ClusterImpl;

public interface Model<T> {	
	
	void addAllElements(List<T> elements);
	void addAllClusters(List<ClusterImpl> clusters);
	
	List<T> getAllElements();
	List<ClusterImpl> getAllClusters();
}
