package fr.cpe.services;

import javax.ejb.Local;

import models.UserModel;
import models.UserResponseModel;

@Local
public interface IAuthenticationService {

	UserResponseModel checkUser(UserModel user);
	
}
