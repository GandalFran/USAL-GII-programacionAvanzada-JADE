package model;

public interface Model<T> {	
	
	void addAllElements(List<T> elements);
	void addAllClusters(List<Cluster<T>> clusters);
	
	List<T> getAllElements();
	List<Cluster<T>> getAllClusters();
}
