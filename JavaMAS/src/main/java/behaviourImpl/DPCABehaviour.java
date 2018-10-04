package behaviourImpl;

import ClusterServices.CluserService;
import ClusterServices.DBSCANClusterServiceImpl;
import jade.core.behaviours.CyclicBehaviour;

public class DPCABehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		
		block();
	}


}
