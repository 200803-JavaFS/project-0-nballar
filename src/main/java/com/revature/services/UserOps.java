package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class UserOps {
	
	private static IUserDAO uDao = new UserDAO();
	private static final Logger log = LogManager.getLogger(UserOps.class);
	
	public List<User> getAllUsers() {
		log.info("Getting all Users");
		List<User> list = uDao.getAllUsers();
		return list;
	}
	
	public List<User> getAllUsersByType(String type) {
		log.info("Getting all Users by type "+type);
		List<User> list = uDao.getAllUsersByType(type);
		return list;
	}
	
	public User getUserById(int id) {
		log.info("Getting a User with id: "+id);
		return uDao.getUserById(id);
	}
	
	public boolean createNewUser(User u) {
		log.info("Creating a new User: "+u);
		if (uDao.addUser(u)) {
			return true;
		}
		return false;
	}
		
}
