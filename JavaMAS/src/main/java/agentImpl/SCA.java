package agentImpl;

import behaviourImpl.SCABehaviour;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class SCA extends Agent{

	private static final long serialVersionUID = 1L;

	public void setup() {
		Behaviour behaviour = new SCABehaviour();
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