package fr.cpe.services.impl;

import fr.cpe.services.IAuthenticationService;
import models.UserModel;
import models.UserResponseModel;

public class AuthenticationService implements IAuthenticationService{
	
	public UserResponseModel checkUser(UserModel user) {
		//TODO stuff
		UserResponseModel userResponse = new UserResponseModel(user.getLogin(), true, user.getRole());
		return userResponse;
	}
}
