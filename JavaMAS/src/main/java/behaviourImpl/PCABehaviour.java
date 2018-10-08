package behaviourImpl;

import java.util.List;

import controller.clusterizationController.ClusterController;
import controller.clusterizationController.DBSCANClusterServiceImpl;

import Controllers.ClusterizablePOJO.ClusterizableProject;
import Controllers.DataTypes.ClusterizableElement;
import jade.core.behaviours.CyclicBehaviour;

public class PCABehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		ClusterController<ClusterizableProject> cs = new DBSCANClusterServiceImpl<>();
		List<ClusterizableElement<ClusterizableProject>>[] clusters = null;;
		List<ClusterizableProject> input = null;
		
		cs.clusterize( input, clusters);
		
		block();
	}


}
