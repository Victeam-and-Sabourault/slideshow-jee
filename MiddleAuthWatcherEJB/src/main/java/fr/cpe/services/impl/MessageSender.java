package fr.cpe.services.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

import fr.cpe.models.UserModel;
import fr.cpe.services.MessageSenderLocal;

@Stateless
public class MessageSender implements MessageSenderLocal{
    @Resource(name = "java:/AuthenticationMessageTopic")
    private Topic topic;

    @Inject
    private JMSContext context;

    public void sendMessage(String message) {
        context.createProducer().send(topic, message.toString());
    }
    
    public void sendMessage(UserModel user) {
        context.createProducer().send(topic, user);
    }
}
