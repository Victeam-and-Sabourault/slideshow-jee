package fr.cpe.services.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

import fr.cpe.models.UserModel;
import fr.cpe.services.MessageSenderQueueLocal;

@Stateless
public class MessageSenderQueue implements MessageSenderQueueLocal {
	@Inject
	JMSContext context;
	
	@Resource(mappedName = "java:/AuthenticationMessageQueue")
	Queue queue;
	
	public void sendMessage(String message) {
		context.createProducer().send(queue, message);
	}
	
	public void sendMessage(UserModel user) {
//		try {
//			ObjectMessage message= context.createObjectMessage();
//			message.setObject(user);
			context.createProducer().send(queue, user);
//		} catch(JMSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
