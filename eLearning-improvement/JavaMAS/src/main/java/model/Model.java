package model;

import java.util.List;

import POJO.Cluster;

public interface Model<T> {	
	
	void addAllElements(List<T> elements);
	void addAllClusters(List<Cluster<T>> clusters);
	
	List<T> getAllElements();
	List<Cluster<T>> getAllClusters();
}
