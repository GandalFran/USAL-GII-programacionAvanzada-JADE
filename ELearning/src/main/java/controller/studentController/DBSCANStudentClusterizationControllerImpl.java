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

		DBSCANClusterer<Student> clusterer = new DBSCANClusterer<>(Constants.MAXRADIUS,Constants.MINPOINTS);

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