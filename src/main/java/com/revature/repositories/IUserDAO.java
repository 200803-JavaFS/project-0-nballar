package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {
	
	public List<User> getAllUsers();
	public List<User> getAllUsersByType(String type);
	public User getUserById(int userId);
	public boolean addUser(User u);
	
}
