package agent.agentImpl;

import agent.behaviour.StudentClusterBehaviour;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import utils.Constants;

public class SCA extends Agent{

	private static final long serialVersionUID = 1L;

	public void setup() {
		Behaviour behaviour = new StudentClusterBehaviour(Constants.STUDENTS_FILE_PATH,Constants.STUDENT_CLUSTERS_FILE_PATH);
		this.addBehaviour(behaviour);
		
		try {
			DFService.register( this,  getAgentDescriptionWithServices() );
		} catch (FIPAException e) {
			System.exit(0);
		}
	}
	
	private DFAgentDescription getAgentDescriptionWithServices() {
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();

		sd.setName( Constants.SCA_NAME);
		sd.setType( Constants.SCA_SERVICE_NAME);
		sd.addOntologies( Constants.ONTOLY_NAME );
		sd.addLanguages( new SLCodec().getName() );
		dfd.addServices(sd);
		
		dfd.setName( this.getAID() );
		
		return dfd;
	}
}
