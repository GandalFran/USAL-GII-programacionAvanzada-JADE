package agentImpl;

import POJO.Student;
import behaviourImpl.EnviromentChangesDetectionBehaviour;
import behaviourImpl.NotDoingNothingBehaviour;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import utils.Constants;

public class DSCA extends Agent{

	private static final long serialVersionUID = 1L;

	public void setup() {
		Behaviour behaviour =  /*new EnviromentChangeDetectionBehaviour<Student>();*/ new NotDoingNothingBehaviour();
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

		sd.setName( Constants.DSCA_SERVICE_NAME );
		sd.setType( Constants.DPCA_DSCA_CHANGE_DETECTION_SERVICE_TYPE );
		sd.addOntologies( Constants.ONTOLY_NAME );
		sd.addLanguages( new SLCodec().getName() );
		dfd.addServices(sd);
		
		dfd.setName( this.getAID() );
		
		return dfd;
	}
}
