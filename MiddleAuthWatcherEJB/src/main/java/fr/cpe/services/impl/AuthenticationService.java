package fr.cpe.services.impl;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import fr.cpe.services.IAuthenticationService;
import fr.cpe.services.MessageReceiverSyncLocal;
import fr.cpe.services.MessageSenderLocal;
import models.UserModel;
import models.UserResponseModel;

public class AuthenticationService implements IAuthenticationService {

	@EJB
	MessageSenderLocal sender;
	@EJB
	MessageReceiverSyncLocal receiver;

	public UserResponseModel checkUser(UserModel user) {

		ObjectMessage msg = (ObjectMessage) user;
		sender.sendMessage(user);

		Message response = receiver.receiveMessage();
		msg = (ObjectMessage) response;
		UserResponseModel userResponse = new UserResponseModel();
		
		try {
			if (msg.getObject() instanceof UserModel) {
				userResponse.setLogin(((UserModel) response).getLogin());
				userResponse.setValidAuth(true);
				userResponse.setRole(((UserModel) response).getRole());
			} else {
				userResponse = new UserResponseModel(user.getLogin(), false, "Unauthorized");
			}

		} catch (JMSException e) {
			e.printStackTrace();
		}

		return userResponse;
	}

}
