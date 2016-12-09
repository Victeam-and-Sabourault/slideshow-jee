package model;

import models.UserModel;

public class DataContainer {
	
	public UserModel checkUser(UserModel user) {
		
		//TODO replace with check in DAO
		UserModel validUser = new UserModel("admin", "admin", null, null, "admin");
		
		return validUser;
	}
}
