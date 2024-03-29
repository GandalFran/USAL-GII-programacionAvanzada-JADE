package controller.communicationServices;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

import controller.CommunicationController;
import jade.content.lang.sl.SLCodec;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.Envelope;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class JadeCommunicationControllerImpl implements CommunicationController{

	
	@Override
	public ACLMessage receiveMessageBlocking(Agent agent, String ontology) {
		ACLMessage msg= agent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchAll(), MessageTemplate.MatchOntology(ontology)));
		return msg;
	}
	
	@Override
	public ACLMessage receiveMessageBlocking(Agent agent, String ontology, int performative) {
		ACLMessage msg= agent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(performative), MessageTemplate.MatchOntology(ontology)));
		return msg;
	}

    /**
     * Env�a un objeto desde el agent eindicado a un agent eque proporciona un servicio del tipo dado
     * @param agent Agente desde el que se va a enviar el servicio
     * @param tipo Tipo del servicio buscado
     * @param objeto Mensaje a Enviar
     */
	@Override
    public boolean sendMessage(Agent agent, String type, Object objeto, String ontology, int performative)
    {
        DFAgentDescription[] dfd;
        dfd=buscarAgentes(agent, type);
        
        try
        {
            if(dfd!=null)
            {
            	ACLMessage aclMessage = new ACLMessage(performative);
            	
            	for(int i=0;i<dfd.length;i++)
	        		aclMessage.addReceiver(dfd[i].getName());
            	
                aclMessage.setOntology(ontology);
                aclMessage.setLanguage(new SLCodec().getName());
                aclMessage.setEnvelope(new Envelope());
				aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
                //aclMessage.getEnvelope().setAclRepresentation(FIPANames.ACLCodec.XML); 
				if(objeto != null)
					aclMessage.setContentObject((Serializable)objeto);
        		agent.send(aclMessage);       		
            }
        }
        catch(IOException e)
        {
            return false;
        }
        return true;
    }
    
	
	/**
	 * Permite buscar a todos los agentes que implementa un servicio de un tipo dado
	 * @param agent Agente con el que se realiza la b�squeda
	 * @param tipo  Tipo de servidio buscado
	 * @return Listado de agentes que proporciona el servicio
	 */
    public DFAgentDescription [] buscarAgentes(Agent agent, String tipo)
    {
        //indico las caracter�sticas el tipo de servicio que quiero encontrar
        DFAgentDescription template=new DFAgentDescription();
        ServiceDescription templateSd=new ServiceDescription();
        templateSd.setType(tipo); //como define el tipo el agente coordinador tamiben podriamos buscar por nombre
        template.addServices(templateSd);
        
        SearchConstraints sc = new SearchConstraints();
        sc.setMaxResults(Long.MAX_VALUE);
        try
        {
            DFAgentDescription [] results = DFService.search(agent, template, sc);
            return results;
        }
        catch(FIPAException e)
        {
            //JOptionPane.showMessageDialog(null, "Agente "+getLocalName()+": "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        	e.printStackTrace();
        }
        
        return null;
    }


    /**
     * Permite buscar los agents que dan un servicio de un determinado tipo. Devuelve el primero de ellos.
     * @param agent Agentes desde el que se realiza la b�squeda
     * @param tipo Tipo de servicio buscado
     * @return Primer agente que proporciona el servicio
     */
    public DFAgentDescription buscarAgente(Agent agent, String type)
    {
        //indico las caracter�sticas el tipo de servicio que quiero encontrar
        DFAgentDescription template=new DFAgentDescription();
        ServiceDescription templateSd=new ServiceDescription();
        templateSd.setType(type); //como define el tipo el agente coordinador tamiben podriamos buscar por nombre
        template.addServices(templateSd);
        
        SearchConstraints sc = new SearchConstraints();
        sc.setMaxResults(new Long(1));
        
        try
        {
            DFAgentDescription [] results = DFService.search(agent, template, sc);
            if (results.length > 0) 
            {
                //System.out.println("Agente "+agent.getLocalName()+" encontro los siguientes agentes");
                for (int i = 0; i < results.length; ++i) 
                {
                    DFAgentDescription dfd = results[i];
                    AID provider = dfd.getName();
                    
                    //un mismo agente puede proporcionar varios servicios, solo estamos interasados en "tipo"
                    @SuppressWarnings("rawtypes")
					Iterator it = dfd.getAllServices();
                    while (it.hasNext())
                    {
                        ServiceDescription sd = (ServiceDescription) it.next();
                        if (sd.getType().equals(type))
                        {
                            System.out.println("- Servicio \""+sd.getName()+"\" proporcionado por el agente "+provider.getName());
                            
                            return dfd;
                        }
                    }
                }
            }	
            else
            {
                //JOptionPane.showMessageDialog(null, "Agente "+getLocalName()+" no encontro ningun servicio buscador", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(FIPAException e)
        {
            //JOptionPane.showMessageDialog(null, "Agente "+getLocalName()+": "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        	e.printStackTrace();
        }
        
        return null;
    }


}
