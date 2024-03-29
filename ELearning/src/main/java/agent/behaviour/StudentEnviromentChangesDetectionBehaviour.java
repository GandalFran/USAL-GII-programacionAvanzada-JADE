package agent.behaviour;

import java.util.Scanner;

import controller.studentController.StudentControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;

public class StudentEnviromentChangesDetectionBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	
	StudentControllerImpl controller = new StudentControllerImpl();
	
	@Override
	public void action() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Pulse S si hay cambios en los estudiantes");
		String s = sc.nextLine();
		
		if(s.toUpperCase().contains("S")) {
			controller.sendMessage(myAgent, Constants.SCA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.REQUEST);
			controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.CONFIRM);	
		}
		
	}
}
