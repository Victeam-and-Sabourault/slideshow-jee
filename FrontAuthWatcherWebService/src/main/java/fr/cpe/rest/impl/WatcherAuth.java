package fr.cpe.rest.impl;

import javax.inject.Inject;

import fr.cpe.dao.IUserDAO;
import fr.cpe.models.UserModel;
import fr.cpe.models.UserResponseModel;
import fr.cpe.rest.IWatcherAuth;
import fr.cpe.services.IAuthenticationService;

/**
 * @author ubuntu
 *
 */
public class WatcherAuth implements IWatcherAuth {

	@Inject
	IAuthenticationService authenticationService;
	
	@Inject
	IUserDAO userDao;


	@Override
	public UserResponseModel authentication(UserModel user) {
		return authenticationService.checkUser(user);
	}


	@Override
	public UserModel authenticationTest(UserModel user) {
		return userDao.checkUser(user);
	}
}
