package fr.cpe.dao;

import javax.ejb.Local;

import fr.cpe.models.UserModel;

@Local
public interface IUserDAO {
	UserModel checkUser(UserModel user);
	
}
