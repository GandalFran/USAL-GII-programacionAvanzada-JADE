package controller.clusterizationController;

import POJO.Cluster;
import java.util.List;

import controller.Clusterizable;


public interface ClusterController<T extends Clusterizable>{
	boolean clusterize(List<T>toCluster, List<Cluster<T>>clusters );
}