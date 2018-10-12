package agentImpl;

import behaviourImpl.MappingStudentsAndHelpersBehaviour;
import behaviourImpl.NotDoingNothingBehaviour;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import utils.Constants;

public class SSMA extends Agent{

	private static final long serialVersionUID = 1L;

	public void setup() {
		Behaviour behaviour = new MappingStudentsAndHelpersBehaviour();
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

		sd.setName( Constants.SSMA_SERVICE_NAME);
		sd.setType( Constants.SPMA_SSMA_MATCHING_SERVICE_TYPE);
		sd.addOntologies( Constants.ONTOLY_NAME);
		sd.addLanguages( new SLCodec().getName() );
		dfd.addServices(sd);
		
		dfd.setName( this.getAID() );
		
		return dfd;
	}
}
