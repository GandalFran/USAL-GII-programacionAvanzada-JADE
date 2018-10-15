package controller.projectController;

import java.util.List;

import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.DBSCANClusterer;

import POJO.Project;
import POJO.ProjectCluster;
import controller.ClusterizationController;
import utils.Constants;

public class DBSCANProjectClusterizationControllerImpl implements ClusterizationController<Project, ProjectCluster>{

	@Override
	public boolean clusterize(List<Project> toCluster, List<ProjectCluster> clusters) {

		DBSCANClusterer<Project> clusterer = new DBSCANClusterer<>(Constants.MAXRADIUS,Constants.MINPOINTS);

		List<Cluster<Project>>clustersTemp=clusterer.cluster(toCluster);
		
		if(clusters==null)
			return false;
		else {
			for(Cluster<Project> c : clustersTemp) {
				clusters.add(new ProjectCluster( c.getPoints() ));
			}
		}	
		
		return true;
	}

}
