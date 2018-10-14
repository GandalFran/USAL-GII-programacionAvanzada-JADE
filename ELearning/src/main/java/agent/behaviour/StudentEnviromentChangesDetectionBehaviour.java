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
		ACLMessage msg = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Pulse S si hay cambios en los estudiantes");
		String s = sc.nextLine();
		
		if(s.equalsIgnoreCase("S")) {
			controller.sendMessage(myAgent, Constants.SCA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.REQUEST);
			do {
				msg = controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.CONFIRM);
			}while(!msg.getSender().getLocalName().equals(Constants.SCA_NAME));
			
		}
	}
}
