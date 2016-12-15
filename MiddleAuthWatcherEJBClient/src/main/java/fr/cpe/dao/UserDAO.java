package fr.cpe.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.cpe.models.UserModel;

@Stateless
public class UserDAO implements IUserDAO{

	@PersistenceContext
	EntityManager em;
	
	public UserModel checkUser(UserModel user) {
		UserModel returnedUser;
		try {
			returnedUser = (UserModel)em.createQuery("FROM UserModel u WHERE u.login = :login AND u.pwd = :pwd")
					.setParameter("login", user.getLogin())
					.setParameter("pwd", user.getPwd())
					.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
		
		return returnedUser;
		
	}
	
}
