package behaviourImpl;

import jade.core.behaviours.CyclicBehaviour;

public class SCABehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		block();
	}


}