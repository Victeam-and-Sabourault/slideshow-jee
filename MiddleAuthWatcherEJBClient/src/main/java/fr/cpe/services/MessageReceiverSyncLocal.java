package fr.cpe.services;

import javax.ejb.Local;
import javax.jms.Message;

@Local
public interface MessageReceiverSyncLocal {
	Message receiveMessage();
}
