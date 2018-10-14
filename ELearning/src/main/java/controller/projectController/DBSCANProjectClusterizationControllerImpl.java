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
		/*Crear una instancia del DBSCAN pasandole como parametros el
		 * numero maximo de distancia entre puntos y el minimo de
		 * miembros de un cluster 
		 */
		DBSCANClusterer<Project> clusterer = new DBSCANClusterer<>(Constants.MAXRADIUS,Constants.MINPOINTS);
		
		/*El metodo cluster solicita una Collection pero list hereda
		 * de collection 
		 */
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
