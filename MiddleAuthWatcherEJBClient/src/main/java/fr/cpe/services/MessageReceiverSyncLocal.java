package fr.cpe.services;

import javax.ejb.Local;

import models.UserModel;

@Local
public interface MessageReceiverSyncLocal {
	UserModel receiveMessage(UserModel message);
}
