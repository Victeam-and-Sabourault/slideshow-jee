package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class UserModel implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected String id;
	
	@NotNull
	@Column(name="login")
	protected String login;
	
	@NotNull
	@Column(name="pwd")
	protected String pwd;
	
	@Column(name="lastname")
	protected String lastname;
	
	@Column(name="firstname")
	protected String firstname;
	
	@Column(name="role")
	protected String role;
	
	public UserModel(){}
	
	public UserModel(String login, String pwd, String lastname, String firstname, String role) {
		super();
		
		this.login = login;
		this.pwd = pwd;
		this.lastname = lastname;
		this.firstname = firstname;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
