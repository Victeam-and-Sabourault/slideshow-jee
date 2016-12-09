package fr.cpe.services.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Queue;

import fr.cpe.services.MessageReceiverSyncLocal;

@Stateless
public class MessageReceiverSync implements MessageReceiverSyncLocal{

    @Resource(name = "java:/AuthenticationMessageQueue")
    private Queue queue;

    @Inject
    private JMSContext context;
	
	public Message receiveMessage() {
		
		JMSConsumer consumer = context.createConsumer(queue);
		
		Message message = consumer.receive(1000);
		
		return message;
	}
	
}
