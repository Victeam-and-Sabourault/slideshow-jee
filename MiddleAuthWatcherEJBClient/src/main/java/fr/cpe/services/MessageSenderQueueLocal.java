package fr.cpe.services;

import javax.ejb.Local;

import fr.cpe.models.UserModel;

@Local
public interface MessageSenderQueueLocal {
	void sendMessage(String message);
	void sendMessage(UserModel user);
}
