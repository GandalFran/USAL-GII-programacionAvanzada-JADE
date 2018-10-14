package controller;

import java.io.Serializable;
import java.util.List;

public interface ICluster<T> extends Serializable{

	List<T> getClusterElements();
	void setClusterElements(List<T> elements);
}
