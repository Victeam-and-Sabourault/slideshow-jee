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

		sender.sendMessage(user);

		System.out.println("Wait for checkedUser from Queue");
		Message response = receiver.receiveMessage();
		System.out.println("Received checkedUser from Queue");
		ObjectMessage msg = (ObjectMessage) response;
		UserResponseModel userResponse = new UserResponseModel();
		
		try {
			if (msg.getObject() instanceof UserModel) {
				UserModel usr = (UserModel) msg.getObject();
				userResponse.setLogin(usr.getLogin());
				userResponse.setValidAuth(true);
				userResponse.setRole(usr.getRole());
			} else {
				userResponse = new UserResponseModel(user.getLogin(), false, "Unauthorized");
			}

		} catch (JMSException e) {
			e.printStackTrace();
		}

		return userResponse;
	}

}
