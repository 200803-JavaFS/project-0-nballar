package com.revature.models;

public class Account {

	private int accountId;
	private int userId;
	private String accountType;
	private double accountBalance;
	private String isApproved;
	
	public Account() {
		super();
		accountId = 0;
		userId = 0;
		accountType = null;
		accountBalance = 0.0d;
		isApproved = null;
	}
	
	public Account(int accountId, int userId, String accountType, double accountBalance, String isApproved) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.isApproved = isApproved;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}
	
	@Override
	public String toString() {
		return "Account [userId=" + userId + ", accountId=" + accountId + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + "]";
	}

}
