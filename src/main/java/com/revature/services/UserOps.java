package com.revature.services;

import com.revature.models.Account;
import com.revature.models.User;

public class UserOps {
	
	User u = new User();
	Account a = new Account();
	String type = u.getUserType();
	
	public void approveAccount() {
		
		if (type == "Employee" | type == "Admin") {
			a.setStatus("Approved!");
			System.out.println("The account number "+a.getAccountId()+" has been approved.");
		} else {
			System.out.println("You do not have the ability to perform this function.");
		}
	}
	
	public void denyAccount() {
		
		if (type == "Employee" | type == "Admin") {
			a.setStatus("Denied!");
			System.out.println("The account number "+a.getAccountId()+" has been denied.");
		} else {
			System.out.println("You do not have the ability to perform this function.");
		}
		
	}
	
}
