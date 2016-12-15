package model;

import javax.ejb.EJB;

import fr.cpe.dao.IUserDAO;
import fr.cpe.models.UserModel;

public class DataContainer {
	
	@EJB
	IUserDAO userDao;
	
	public UserModel checkUser(UserModel user) { 
		return userDao.checkUser(user); 
	}
}
