package controller.controllerImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import POJO.Cluster;
import controller.clusterizationController.ClusterController;
import controller.clusterizationController.Clusterizable;



/*
 * T es o bien ClusterizableProject o ClusterizableSutdent
 * */ 
public class DBSCANClusterizationControllermpl<T extends Clusterizable> implements ClusterController<T>
{
	@Override
	public boolean clusterize(List<T>toCluster, List<Cluster<T>> clusters ) {
		return false;
	}
		
	
}
