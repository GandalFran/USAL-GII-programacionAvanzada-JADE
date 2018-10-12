package agentImpl;

import POJO.Project;
import behaviourImpl.ClusterBehaviour;
import behaviourImpl.NotDoingNothingBehaviour;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import utils.Constants;

public class PCA extends Agent{


	public void setup() {
		Behaviour behaviour = new ClusterBehaviour<Project>(Constants.PROJECTS_FILE_PATH,Constants.PROJECT_CLUSTERS_FILE_PATH);
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

		sd.setName( Constants.PCA_SERVICE_NAME);
		sd.setType( Constants.PCA_SCA_CLUSTERING_SERVICE_TYPE);
		sd.addOntologies( Constants.ONTOLY_NAME );
		sd.addLanguages( new SLCodec().getName() );
		dfd.addServices(sd);
		
		dfd.setName( this.getAID() );
		
		return dfd;
	}
}
