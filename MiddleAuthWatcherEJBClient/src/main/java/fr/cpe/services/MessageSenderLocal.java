package fr.cpe.services;

import javax.ejb.Local;

import fr.cpe.models.UserModel;

@Local
public interface MessageSenderLocal {
	void sendMessage(String message);
	void sendMessage(UserModel user);
}
