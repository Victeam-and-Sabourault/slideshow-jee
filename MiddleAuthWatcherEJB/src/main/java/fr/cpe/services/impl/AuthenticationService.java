package fr.cpe.services.impl;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import fr.cpe.models.UserModel;
import fr.cpe.models.UserResponseModel;
import fr.cpe.services.IAuthenticationService;
import fr.cpe.services.MessageReceiverSyncLocal;
import fr.cpe.services.MessageSenderLocal;

public class AuthenticationService implements IAuthenticationService {

	@EJB
	MessageSenderLocal sender;
	@EJB
	MessageReceiverSyncLocal receiver;

	public UserResponseModel checkUser(UserModel user) {

		UserResponseModel userResponse;

		sender.sendMessage(user);

		Message response = receiver.receiveMessage();
		
		if(response instanceof ObjectMessage) {
			ObjectMessage msg = (ObjectMessage) response;
			userResponse = new UserResponseModel();
			
			try {
				if (msg.getObject() instanceof UserModel) {
					UserModel usr = (UserModel) msg.getObject();
					userResponse.setLogin(usr.getLogin());
					userResponse.setValidAuth(true);
					userResponse.setRole(usr.getRole());
				} else {
					userResponse = new UserResponseModel(user.getLogin(), false, "Internal Server Error");
				}

			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			userResponse = new UserResponseModel(user.getLogin(), false, "Unauthorized");
		}
		
		return userResponse;
	}

}
