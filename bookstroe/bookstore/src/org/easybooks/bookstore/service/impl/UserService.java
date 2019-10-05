package org.easybooks.bookstore.service.impl;
import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.service.*;
import org.easybooks.bookstore.vo.User;
public class UserService implements IUserService{
	private IUserDAO userDAO;
	public IUserDAO getUserDao(){
		return userDAO;
	}
	public void setUserDAO(IUserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public void saveUser(User user){
		userDAO.saveUser(user);
	}

	public User validateUser(String username, String password){
		return userDAO.validateUser(username, password);
	}

	public boolean existUser(String username){
		return userDAO.existUser(username);
	}
}
