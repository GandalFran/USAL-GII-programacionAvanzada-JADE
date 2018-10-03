package behaviourImpl;

import jade.core.behaviours.CyclicBehaviour;

public class DSCABehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		block();
	}


}
