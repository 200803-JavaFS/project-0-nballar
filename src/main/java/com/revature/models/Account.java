package com.revature.models;

public class Account {

	private int userId;
	private int accountId;
	private String accountType;
	private double accountBalance;
	
	public Account() {
		super();
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [userId=" + userId + ", accountId=" + accountId + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + "]";
	}
	
}
