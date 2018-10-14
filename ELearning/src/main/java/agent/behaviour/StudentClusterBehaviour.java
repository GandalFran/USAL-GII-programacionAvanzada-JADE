package agent.behaviour;

import controller.studentController.StudentControllerImpl;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;

public class StudentClusterBehaviour extends CyclicBehaviour{

		private String elementsFilePath;
		private String clustersFilePath;
		private StudentControllerImpl controller;

		public StudentClusterBehaviour(String elementsFilePath, String clustersFilePath) {
			this.elementsFilePath = elementsFilePath;
			this.clustersFilePath = clustersFilePath;
			this.controller = new StudentControllerImpl();
		}
		
		
		@Override
		public void action() {
			boolean result;
			
			ACLMessage msg = controller.receiveMessage(myAgent,Constants.ONTOLY_NAME);
			
			if(msg.getContent().equals("fallo")) {
				System.out.println("Recibido un mensaje de fallo\n");
			}
			AID sender = msg.getSender();

			result = controller.importElements(elementsFilePath);
			if(result == true )
				result = controller.clusterize();
			if(result == true)
				result = controller.exportClusters(clustersFilePath);


			if( false == result ) {
				if(!controller.sendMessage(myAgent,sender.getLocalName(),"fallo",Constants.ONTOLY_NAME )) {
					System.out.println("Error al enviar mensaje de fallo\n");
				}
			}else {
				if(!controller.sendMessage(myAgent,sender.getLocalName(),"bien",Constants.ONTOLY_NAME )) {
					System.out.println("Error al enviar mensaje de bien\n");
				}
				if(!controller.sendMessage(myAgent,Constants.SPMA_SERVICE_NAME,"bien",Constants.ONTOLY_NAME )) {
					System.out.println("Error al enviar mensaje a SPMA\n");
				}
				if(!controller.sendMessage(myAgent,Constants.SSMA_SERVICE_NAME,"bien",Constants.ONTOLY_NAME )) {
					System.out.println("Error al enviar mensaje a SSMA\n");
				}
			}
			
		}
	}