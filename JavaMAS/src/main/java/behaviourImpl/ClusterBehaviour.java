package behaviourImpl;

import java.util.ArrayList;
import java.util.List;

import POJO.Cluster;
import controller.Clusterizable;
import controller.Controller;
import controller.ControllerImpl;
import jade.core.behaviours.CyclicBehaviour;

public class ClusterBehaviour<T extends Clusterizable> extends CyclicBehaviour{

	private String elementsFilePath;
	private String clustersFilePath;
	private Controller<T> controller;

	public ClusterBehaviour(String elementsFilePath, String clustersFilePath) {
		this.elementsFilePath = elementsFilePath;
		this.clustersFilePath = clustersFilePath;
		this.controller = new ControllerImpl<T>();
	}
	
	@Override
	public void action() {
		boolean result;
		
		//reciveB(msg)
		//sebnd(msg.emisor aceptar tarea);
		
		result = controller.importElements(elementsFilePath);
		if(result == true )
			result = controller.clusterize();
		if(result == true)
			result = controller.exportClusters(clustersFilePath);

		
		if( false == result ) {
			//send( msg.emisor fallo )
		}else {
			//send( msg.emisor bien )
			//send( SSMA y SPMA tarea)
		}
		
	}


}