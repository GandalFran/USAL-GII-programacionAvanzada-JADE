package behaviourImpl;

import org.apache.commons.math3.ml.clustering.Clusterable;

import controller.Controller;
import controller.controllerImpl.ControllerImpl;
import jade.core.behaviours.CyclicBehaviour;

public class EnviromentChangesDetectionBehaviour<T extends Clusterable> extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;

	Controller<T> controller = new ControllerImpl<T>();
	
	@Override
	public void action() {
		//checkear actualizaciones
		
		//if hay actualizacion
			//msg(PCA o SCA)
			//reciveB(PCA o SCA)
		
		block();
	}


}
