package controller;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.math3.ml.clustering.Clusterable;

public interface ICluster<T> extends Serializable{

	List<T> getClusterElements();
	void setClusterElements(List<T> elements);
}
