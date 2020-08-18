package com.revature.services;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.User;

public class UserOpsTests {

	public static User u;
	public static UserOps uo;
	public static String uName;
	public static String uPass;
	
	@BeforeClass
	public static void setUser() {
		uo = new UserOps();
		u = uo.getUserById(5);
	}
	
	@Before
	public void setFields() {
		uName = u.getUserName();
		uPass = u.getPassWord();
	}
	
	@After
	public void clearFields() {
		uName = null;
		uPass = null;
	}
	
	@AfterClass
	public static void resetUser() {
		uo = null;
	}
	
	@Test
	public void testLogIn() {
		assertTrue(uo.logInUser(u.getUserId(), uName, uPass));
	}
}
