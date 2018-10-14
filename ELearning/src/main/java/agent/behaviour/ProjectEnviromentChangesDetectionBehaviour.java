package agent.behaviour;

import controller.projectController.ProjectControllerImpl;
import jade.core.behaviours.CyclicBehaviour;

public class ProjectEnviromentChangesDetectionBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	
	ProjectControllerImpl controller = new ProjectControllerImpl();
	
	@Override
	public void action() {
		//checkear actualizaciones
		
		//if hay actualizacion
			//msg(PCA o SCA)
			//reciveB(PCA o SCA)
		
		block();
	}
}