package fr.cpe.services.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

import fr.cpe.services.MessageReceiverSyncLocal;
import models.UserModel;

@Stateless
public class MessageReceiverSync implements MessageReceiverSyncLocal{

    @Resource(name = "java:/AuthenticationMessageTopic")
    private Topic topic;

    @Inject
    private JMSContext context;
	
	public UserModel receiveMessage(UserModel message) {
		
		//UserModel message = ((UserModel)context.createConsumer(queue));
		
		return message;
	}
	
}
