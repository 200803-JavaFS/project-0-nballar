package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.AccountDAO;
import com.revature.repositories.IAccountDAO;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class AccountOps {

	private static IAccountDAO aDao = new AccountDAO();
	private static IUserDAO uDao = new UserDAO();
	private static final Logger log = LogManager.getLogger(AccountOps.class);
	
	public List<Account> getAllAccounts(){
		log.info("Getting all Accounts");
		List<Account> list = aDao.getAllAccounts();
		return list;
	}
	
	public List<Account> getAccountsByUserId(User userId) {
		log.info("Getting Accounts by User's ID: "+userId);
		List<Account> list = aDao.getAllAccountsByUserId(userId);
		return list;
	}
	
	public Account getAccountById(int id) {
		log.info("Getting Account by ID: "+id);
		Account a = aDao.getAccountById(id);
		return a;
	}
	
	public boolean createNewAccount(Account a) {
		if (a.getUserId() != null) {
			List<User> list = uDao.getAllUsers();
			boolean b = false;
			for (User u : list) {
				if (u.equals(a.getUserId())) {
					b = true;
				}
			}
			if (b) {
				log.info("Creating a new Account: "+a);
				if (aDao.addAccount(a)) {
					return true;
				}
			}
		} else {
			log.info("Creating a new Account: "+a);
			if(aDao.addAccount(a)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean updateAccountStatus(Account a) {
		log.info("Updating Account Status of Account: "+a);
		if (aDao.updateAccountStatus(a)) {
			return true;
		}
		return false;
	}
	
	public boolean updateAccountBalance(Account a) {
		log.info("Updating Account Balance of Account: "+a);
		if (aDao.updateAccountBalance(a)) {
			return true;
		}
		return false;
	}
	
	public double deposit(Account a, double amt) {
		if (amt <= 0) {
			log.info("You can not deposit a negative amount or nothing.");
		} else {
			log.info("Depositing "+amt+" into Account "+a);
			double newBalance = a.getAccountBalance() + amt;
			a.setAccountBalance(newBalance);
		}
		return a.getAccountBalance();
	}
	
	public double withdraw(Account a, double amt) {
		if (amt <= 0) {
			log.info("You can not withdraw a negative amount or nothing.");
		} else if (amt > a.getAccountBalance()) {
			log.info("You can not overdraw from your account.");
		} else {
			log.info("Withdrawing "+amt+" from Account "+a);
			double newBalance = a.getAccountBalance() - amt;
			a.setAccountBalance(newBalance);
		}
		return a.getAccountBalance();
	}
	
	public void transferTo(Account a, Account b, double amt) {
		if (amt > a.getAccountBalance()) {
			log.info("You do not have enough funds to complete this transfer.");
		} else {
			log.info("Transferring "+amt+" from Account "+a+" to Account "+b);
			double newBalanceA = withdraw(a, amt);
			a.setAccountBalance(newBalanceA);
			double newBalanceB = deposit(b, amt);
			b.setAccountBalance(newBalanceB);
		}
	}
}
