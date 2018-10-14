package agent.behaviour;

import java.util.Scanner;

import controller.projectController.ProjectControllerImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;

public class ProjectEnviromentChangesDetectionBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	
	ProjectControllerImpl controller = new ProjectControllerImpl();
	
	@Override
	public void action() {
		ACLMessage msg = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Pulse P si hay cambios en los proyectos");
		String s = sc.nextLine();
		
		if(s.toUpperCase().contains("P")) {
			controller.sendMessage(myAgent, Constants.PCA_NAME, null, Constants.ONTOLY_NAME, ACLMessage.REQUEST);
			do {
				msg = controller.receiveMessage(myAgent,Constants.ONTOLY_NAME, ACLMessage.CONFIRM);
			}while(!msg.getSender().getLocalName().equals(Constants.PCA_NAME));
			
		}
	}
}