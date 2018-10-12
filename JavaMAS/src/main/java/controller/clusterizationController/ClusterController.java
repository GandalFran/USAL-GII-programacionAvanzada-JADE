package controller.clusterizationController;

import POJO.ClusterImpl;

import java.util.List;

import org.apache.commons.math3.ml.clustering.Clusterable;


public interface ClusterController<T extends Clusterable>{
	boolean clusterize(List<T>toCluster, List<ClusterImpl>clusters );
}
