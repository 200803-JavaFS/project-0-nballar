package com.revature.services;

import com.revature.models.Account;

public class AccountOps {

	Account a = new Account();
	Double balance = a.getAccountBalance();
	
	public void deposit(double amt) {
		balance+=amt;
		a.setAccountBalance(balance);
		System.out.println("New balance is :"+balance);
	}
	
	public void withdraw(double amt) {
		if(balance>amt) {
			balance-=amt;
			a.setAccountBalance(balance);
		}
		
		if(balance<0) {
			System.out.println("This transaction can't occur.");
		}else {
			System.out.println("Remaining balance="+balance);
		}
	}
	
	public void transfer(double amt, Account b) {
		if(amt<=balance) {
			withdraw(amt);
			b.setAccountBalance(b.getAccountBalance()+amt);
			System.out.println("Transfer successful. New balance for first account is :"+balance);
			System.out.println("New balance for second account is :"+b.getAccountBalance());
		}
	}
}
