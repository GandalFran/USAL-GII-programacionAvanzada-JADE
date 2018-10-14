package controller.studentController;

import java.util.List;

import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.DBSCANClusterer;

import POJO.Student;
import POJO.StudentCluster;
import controller.ClusterizationController;
import utils.Constants;

public class DBSCANStudentClusterizationControllerImpl implements ClusterizationController<Student, StudentCluster>{

	@Override
	public boolean clusterize(List<Student> toCluster, List<StudentCluster> clusters) {
		/*Crear una instancia del DBSCAN pasandole como parametros el
		 * numero maximo de distancia entre puntos y el minimo de
		 * miembros de un cluster 
		 */
		DBSCANClusterer<Student> clusterer = new DBSCANClusterer<>(Constants.MAXRADIUS,Constants.MINPOINTS);
		
		/*El metodo cluster solicita una Collection pero list hereda
		 * de collection 
		 */
		List<Cluster<Student>>clustersTemp=clusterer.cluster(toCluster);
		
		if(clusters==null)
			return false;
		else {
			for(Cluster<Student> c : clustersTemp) {
				clusters.add(new StudentCluster( c.getPoints() ));
			}
		}	
		
		return true;
	}

}