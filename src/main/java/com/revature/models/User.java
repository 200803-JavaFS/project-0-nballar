package com.revature.models;

public class User {
	
	private int userId;
	private String userName;
	private String passWord;
	private String userType;
	private String firstName;
	private String lastName;
	private int birthDate;
	private String email;
	private int phoneNumber;
	
	public User() {
		super();
		userId = 0;
		userName = null;
		passWord = null;
		userType = null;
		firstName = null;
		lastName = null;
		birthDate = 0;
		email = null;
		phoneNumber = 0;
	}
	
	public User(int userId, String username, String password, String userType, String firstName, String lastName, int birthdate,
			String email, int phoneNumber) {
		super();
		this.userId = userId;
		this.userName = username;
		this.passWord = password;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthdate;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String username) {
		this.userName = username;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String password) {
		this.passWord = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthdate) {
		this.birthDate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", userType=" + userType
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", email="
				+ email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
