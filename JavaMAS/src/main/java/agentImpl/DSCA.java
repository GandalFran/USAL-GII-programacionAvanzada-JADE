package agentImpl;

import POJO.Student;
import behaviourImpl.EnviromentChangesDetectionBehaviour;
import behaviourImpl.NotDoingNothingBehaviour;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class DSCA extends Agent{

	private static final long serialVersionUID = 1L;

	public void setup() {
		Behaviour behaviour =  /*new EnviromentChangeDetectionBehaviour<Student>();*/ new NotDoingNothingBehaviour();
		this.addBehaviour(behaviour);
		
		/*try {
			DFService.register( this,  getAgentDescriptionWithServices() );
		} catch (FIPAException e) {
			System.exit(0);
		}*/
	}
	
	/*private DFAgentDescription getAgentDescriptionWithServices() {
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();

		sd.setName( );
		sd.setType( );
		sd.addOntologies( );
		sd.addLanguages( new SLCodec().getName() );
		dfd.addServices(sd);
		
		dfd.setName( this.getAID() );
		
		return dfd;
	}*/
}
