package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtility;

public class AccountDAO implements IAccountDAO{

	private IUserDAO uDao = new UserDAO();
	
	@Override
	public List<Account> getAllAccounts() {
		
		try(Connection con = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts;";
			
			Statement stmt = con.createStatement();
			
			List<Account> list = new ArrayList<>();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Account a = new Account();
				a.setAccountId(rs.getInt("account_id"));
				a.setAccountType(rs.getString("account_type"));
				a.setAccountBalance(rs.getDouble("account_balance"));
				a.setStatus(rs.getString("status"));
				
				if (rs.getString("user_id_fk") != null) {
					a.setUserId(uDao.getUserById(rs.getInt("user_id_fk")));
				}
				
				list.add(a);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Account> getAllAccountsByUserId(User userId) {
		try (Connection con = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE user_id_fk = "+userId+";";
			
			Statement stmt = con.createStatement();
			
			List<Account> list = new ArrayList<>();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Account a = new Account();
				a.setAccountId(rs.getInt("account_id"));
				a.setAccountType(rs.getString("account_type"));
				a.setAccountBalance(rs.getDouble("account_balance"));
				a.setStatus(rs.getString("status"));
				
				if (rs.getString("user_id_fk") != null) {
					a.setUserId(uDao.getUserById(rs.getInt("user_id_fk")));
				}
				
				list.add(a);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Account getAccountById(int accountId) {
		try (Connection con = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE account_id = "+accountId+";";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				Account a = new Account();
				a.setAccountId(rs.getInt("account_id"));
				a.setAccountType(rs.getString("account_type"));
				a.setAccountBalance(rs.getDouble("account_balance"));
				a.setStatus(rs.getString("status"));
				
				if (rs.getString("user_id_fk") != null) {
					a.setUserId(uDao.getUserById(rs.getInt("user_id_fk")));
				}
				
				return a;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		try (Connection con = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO accounts (user_id_fk, account_type, account_balance, status)"
					+ "VALUES (?, ?, ?, ?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			int i = 0;
			if(a.getUserId() != null) {
				User u = a.getUserId();
				stmt.setInt(++i, u.getUserId());
			}
			
			stmt.setString(++i, a.getAccountType());
			stmt.setDouble(++i, a.getAccountBalance());
			stmt.setString(++i, a.getStatus());
			
			stmt.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateAccountStatus(Account a) {
		try (Connection con = ConnectionUtility.getConnection()) {
			String sql = "UPDATE accounts SET status = ? WHERE account_id = ?;";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			int i = 0;
			stmt.setString(++i, a.getStatus());
			stmt.setInt(++i, a.getAccountId());
			
			stmt.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean updateAccountBalance(Account a) {
		try (Connection con = ConnectionUtility.getConnection()) {
			String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?;";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			int i = 0;
			stmt.setDouble(++i, a.getAccountBalance());
			stmt.setInt(++i, a.getAccountId());
			
			stmt.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
}
