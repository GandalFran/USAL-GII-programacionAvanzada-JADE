package controller.controllerImpl;

import java.util.List;

import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.clustering.DBSCANClusterer;

import POJO.ClusterImpl;
import controller.clusterizationController.ClusterController;
import utils.Constants;



/*
 * T es o bien ClusterizableProject o ClusterizableStudent
 * */ 
public class DBSCANClusterizationControllermpl<T extends Clusterable> implements ClusterController<T>
{
	@Override
	public boolean clusterize(List<T>toCluster, List<ClusterImpl> clusters ) {
		/*Crear una instancia del DBSCAN pasandole como parametros el
		 * numero maximo de distancia entre puntos y el minimo de
		 * miembros de un cluster 
		 */
		DBSCANClusterer<T> clusterer = new DBSCANClusterer<>(Constants.MAXRADIUS,Constants.MINPOINTS);
		
		/*El metodo cluster solicita una Collection pero list hereda
		 * de collection 
		 */
		//clusters=clusterer.cluster(toCluster);
		
		if(clusters==null)
			return false;
		
		return true;
	}
		
	
}
