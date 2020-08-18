package com.revature.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Account;

public class AccountOpsTests {
	
	public static Account test1;
	public static Account test2;
	public static AccountOps ao;
	public static double amt;
	public static double result;
	public static double[] results;
	
	@BeforeClass
	public static void setAccounts() {
		ao = new AccountOps();
		test1 = ao.getAccountById(5);
		test2 = ao.getAccountById(6);
	}
	
	@Before
	public void setFields() {
		amt = 1000.00;
		result = 0.00;
		results = new double[2];
		results[0] = 0.00;
		results[1] = 0.00;
	}
	
	@After
	public void clearResults() {
		result = 0.00;
		results[0] = 0.00;
		results[1] = 0.00;
	}
	
	@AfterClass
	public static void resetAccounts() {
		test1.setAccountBalance(7000.00);
		test2.setAccountBalance(5000.00);
		
		ao.updateAccountBalance(test1);
		ao.updateAccountBalance(test2);
		
		ao = null;
	}
	
	@Test
	public void testDeposit() {
		System.out.println("Testing Deposit Function");
		result = ao.deposit(test1.getAccountId(), amt);
		assertTrue(result == 8000.00);
	}
	
	@Test
	public void testWithdraw() {
		System.out.println("Testing Withdraw Function");
		result = ao.withdraw(test2.getAccountId(), amt);
		assertTrue(result == 4000.00);
	}
	
	@Test
	public void testTransfer() {
		System.out.println("Testing Transfer Function");
		results = ao.transferTo(test1.getAccountId(), test2.getAccountId(), amt);
		double[] expected = {7000.00, 5000.00};
		double delta = 0.00;
		assertArrayEquals(expected, results, delta);
	}
}
