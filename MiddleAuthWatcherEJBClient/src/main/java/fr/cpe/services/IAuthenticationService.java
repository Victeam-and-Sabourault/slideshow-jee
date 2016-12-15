package fr.cpe.services;

import javax.ejb.Local;

import fr.cpe.models.UserModel;
import fr.cpe.models.UserResponseModel;

@Local
public interface IAuthenticationService {

	UserResponseModel checkUser(UserModel user);
	
}
