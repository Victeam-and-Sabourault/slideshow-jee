package fr.cpe.rest.impl;

import javax.inject.Inject;

import fr.cpe.rest.IWatcherAuth;
import fr.cpe.services.IAuthenticationService;
import fr.cpe.services.MessageReceiverSyncLocal;
import fr.cpe.services.MessageSenderLocal;
import models.UserModel;
import models.UserResponseModel;

/**
 * @author ubuntu
 *
 */
public class WatcherAuth implements IWatcherAuth {

	@Inject
	IAuthenticationService authenticationService;


	@Override
	public UserResponseModel authentication(UserModel user) {
		return authenticationService.checkUser(user);
	}
}
