package behaviourImpl;

import controller.Clusterizable;
import controller.Controller;
import controller.ControllerImpl;
import jade.core.behaviours.CyclicBehaviour;

public class EnviromentChangesDetectionBehaviour<T extends Clusterizable> extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;

	Controller<T> controller;
	
	public EnviromentChangesDetectionBehaviour() {
		this.controller = new ControllerImpl<T>();
	}
	
	@Override
	public void action() {
		//checkear actualizaciones
		
		//if hay actualizacion
			//msg(PCA o SCA)
			//reciveB(PCA o SCA)
		
		block();
	}


}
