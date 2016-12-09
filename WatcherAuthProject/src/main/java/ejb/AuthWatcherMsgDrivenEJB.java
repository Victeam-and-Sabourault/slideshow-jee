package ejb;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import fr.cpe.services.MessageSenderQueueLocal;
import model.DataContainer;
import models.UserModel;

// Abonnement au topic
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"), 
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/AuthenticationMessageTopic") })
public class AuthWatcherMsgDrivenEJB implements MessageListener {
	private DataContainer dataContainer;

	@EJB
	MessageSenderQueueLocal sender; //Instanciation de la queue pour sendmessage

	public AuthWatcherMsgDrivenEJB() {
		super();
		dataContainer = new DataContainer();
	}

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				System.out.println("Topic: I received a TextMessage at " + new Date());
				TextMessage msg = (TextMessage) message;

				System.out.println("Message is : " + msg.getText());

			} else if (message instanceof ObjectMessage) {

				System.out.println("Topic: I received an ObjectMessage at " + new Date());
				ObjectMessage msg = (ObjectMessage) message;

				if (msg.getObject() instanceof UserModel) {

					UserModel user = (UserModel) msg.getObject();
					System.out.println("User Details: ");
					System.out.println("login:" + user.getLogin());
					System.out.println("pwd:" + user.getPwd());

					UserModel checkedUser = dataContainer.checkUser(user);
					
					if(checkedUser != null) {	
						System.out.println("Put checkedUser on Queue");
						sender.sendMessage(checkedUser);
					} else {
						sender.sendMessage("Error : Invalid user");
					}
					
				} else {
					System.out.println("Not valid message for this Queue MDB");
				}

			}
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
