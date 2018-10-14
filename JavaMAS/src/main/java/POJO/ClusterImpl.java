package POJO;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.math3.ml.clustering.Clusterable;


public interface ClusterImpl<T extends Clusterable> extends Serializable{
	public List<T> getClusterElements();
	public void setClusterElements(List<T> clusterElements);
}
