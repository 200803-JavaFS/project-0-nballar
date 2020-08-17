package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtility;

public class UserDAO implements IUserDAO {
	
	@Override
	public List<User> getAllUsers() {
		
		try (Connection con = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM users;";
			
			Statement stmt = con.createStatement();
			
			List<User> list = new ArrayList<>();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setUserName(rs.getString("user_name"));
				u.setPassWord(rs.getString("pass_word"));
				u.setUserType(rs.getString("user_type"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setBirthDate(rs.getInt("birth_date"));
				u.setEmail(rs.getString("email"));
				list.add(u);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<User> getAllCustomers() {
		try(Connection con = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users WHERE user_type = 'Customer';";
			
			Statement stmt = con.createStatement();
			
			List<User> list = new ArrayList<>();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setUserName(rs.getString("user_name"));
				u.setPassWord(rs.getString("pass_word"));
				u.setUserType(rs.getString("user_type"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setBirthDate(rs.getInt("birth_date"));
				u.setEmail(rs.getString("email"));
				list.add(u);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public User getUserById(int userId) {
		try(Connection con = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM users WHERE user_id = "+userId+";";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setUserName(rs.getString("user_name"));
				u.setPassWord(rs.getString("pass_word"));
				u.setUserType(rs.getString("user_type"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setBirthDate(rs.getInt("birth_date"));
				u.setEmail(rs.getString("email"));
				return u;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addUser(User u) {
		
		try(Connection con = ConnectionUtility.getConnection()){
			String sql = "INSERT INTO users (user_name, pass_word, user_type, first_name, last_name, birth_date, email)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			int i = 0;
			stmt.setString(++i, u.getUserName());
			stmt.setString(++i, u.getPassWord());
			stmt.setString(++i, u.getUserType());
			stmt.setString(++i, u.getFirstName());
			stmt.setString(++i, u.getLastName());
			stmt.setInt(++i, u.getBirthDate());
			stmt.setString(++i, u.getEmail());
			
			stmt.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
	
}
