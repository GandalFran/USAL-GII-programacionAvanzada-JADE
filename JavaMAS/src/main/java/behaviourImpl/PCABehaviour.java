package behaviourImpl;

import java.util.List;

import ClusterServices.CluserService;
import ClusterServices.DBSCANClusterServiceImpl;
import ClusterServices.ClusterizablePOJO.ClusterizableProject;
import ClusterServices.DataTypes.ClusterizableElement;
import jade.core.behaviours.CyclicBehaviour;

public class PCABehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		CluserService<ClusterizableProject> cs = new DBSCANClusterServiceImpl<>();
		List<ClusterizableElement<ClusterizableProject>>[] clusters = null;;
		List<ClusterizableProject> input = null;
		
		cs.clusterize( input, clusters);
		
		block();
	}


}
