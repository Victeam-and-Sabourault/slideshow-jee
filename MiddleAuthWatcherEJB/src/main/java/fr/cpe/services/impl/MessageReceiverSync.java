package fr.cpe.services.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Topic;

import fr.cpe.services.MessageReceiverSyncLocal;

@Stateless
public class MessageReceiverSync implements MessageReceiverSyncLocal{

    @Resource(name = "java:/AuthenticationMessageTopic")
    private Topic topic;

    @Inject
    private JMSContext context;
	
	public Message receiveMessage() {
		
		JMSConsumer consumer = context.createConsumer(topic);
		
		Message message = consumer.receive();
		
		return message;
	}
	
}
