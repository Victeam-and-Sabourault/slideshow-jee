package fr.cpe.services;

import javax.ejb.Local;

import models.UserModel;

@Local
public interface MessageSenderQueueLocal {
	void sendMessage(String message);
	void sendMessage(UserModel user);
}
