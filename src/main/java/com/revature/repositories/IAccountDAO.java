package com.revature.repositories;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;

public interface IAccountDAO {

	public List<Account> getAllAccounts();
	public List<Account> getAllAccountsByUserId(User userId);
	
	public Account getAccountById(int accountId);
	
	public boolean addAccount(Account a);
	public boolean updateAccountStatus(Account a);
	public boolean updateAccountBalance(Account a);
	
}
