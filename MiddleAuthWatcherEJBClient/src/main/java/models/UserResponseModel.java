package models;

import java.io.Serializable;


public class UserResponseModel  implements Serializable{

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getValidAuth() {
		return validAuth;
	}

	public void setValidAuth(Boolean validAuth) {
		this.validAuth = validAuth;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	protected String login;
	protected Boolean validAuth;
	protected String role;
	
	public UserResponseModel() {
		super();
	}
	
	public UserResponseModel(String login, Boolean validAuth, String role) {
		super();
		this.login = login;
		this.validAuth = validAuth;
		this.role = role;
	}
	
}
