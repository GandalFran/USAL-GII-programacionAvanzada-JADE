package agent.behaviour;

import controller.studentController.StudentControllerImpl;
import jade.core.behaviours.CyclicBehaviour;

public class StudentEnviromentChangesDetectionBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	
	StudentControllerImpl controller = new StudentControllerImpl();
	
	@Override
	public void action() {
		//checkear actualizaciones
		
		//if hay actualizacion
			//msg(PCA o SCA)
			//reciveB(PCA o SCA)
		
		block();
	}
}
