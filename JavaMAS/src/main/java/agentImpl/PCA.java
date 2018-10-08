package agentImpl;

import POJO.Project;
import behaviourImpl.ClusterBehaviour;
import behaviourImpl.NotDoingNothingBehaviour;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import utils.Constants;

public class PCA extends Agent{


	public void setup() {
		Behaviour behaviour = /*new ClusterBehaviour<Project>(Constants.PROJECTS_FILE_PATH,Constants.PROJECT_CLUSTERS_FILE_PATH);*/ new NotDoingNothingBehaviour();
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
