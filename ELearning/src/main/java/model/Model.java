package model;

import java.util.List;


public interface Model<E,C> {	
	
	void addAllElements(List<E> elements);
	void addAllClusters(List<C> clusters);
	
	List<E> getAllElements();
	List<C> getAllClusters();
	
	void clear();
}

