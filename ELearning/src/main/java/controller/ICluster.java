package controller;

import java.util.List;

public interface ICluster<T>{

	List<T> getClusterElements();
	void setClusterElements(List<T> elements);
}
