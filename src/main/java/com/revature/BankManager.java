package com.revature;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountOps;
import com.revature.services.UserOps;

public class BankManager {
	
	private static final Scanner scan = new Scanner(System.in);
	private UserOps uo = new UserOps();
	private AccountOps ao = new AccountOps();
	
	public void bankManagement() {
		
		System.out.println("Welcome to Little Baller Bank!");
		System.out.println("What would you like to do?\n"+"[a] Log In\n"+"[b] Create a New User\n"+"[c] Exit");
		String ans1 = scan.nextLine();
		firstMenu(ans1);
	}

	private void firstMenu(String ans1) {
		ans1 = ans1.toLowerCase();
		
		switch(ans1) {
			case "a":
				try {
					logIn();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					bankManagement();
				}
				System.out.println("What is your user type?\n"+"[a] Customer\n"+"[b] Employee\n"+"[c] Admin");
				String ans2 = scan.nextLine();
				secondMenu(ans2);
				break;
			case "b":
				createNewUser();
				System.out.println("Thanks for joining Little Baller Bank!\n"
						+"Please start again from the beginning to log in with your new user credentials.");
				bankManagement();
				break;
			case "c":
				System.out.println("Thanks for ballin' with Little Baller Bank! Have a great day!");
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again.");
				bankManagement();
				break;
		}
		
	}

	private void createNewUser() {
		System.out.println("What is the username you would like to go with?");
		String uName = scan.nextLine();
		System.out.println("What is the password you would like to go with?");
		String uPass = scan.nextLine();
		System.out.println("What is your user type?");
		String uType = scan.nextLine();
		System.out.println("What is your first name?");
		String fName = scan.nextLine();
		System.out.println("What is your last name?");
		String lName = scan.nextLine();
		System.out.println("What is your birth date? Please type the month and day. (Example: September 10th => 0910)");
		int bDate = scan.nextInt();
		scan.nextLine();
		System.out.println("What is your email address?");
		String email = scan.nextLine();
		User u = new User(uName, uPass, uType, fName, lName, bDate, email);
		
		if (uo.createNewUser(u)) {
			System.out.println("You've been added to our database.");
		} else {
			System.out.println("Something went wrong. Please try again.");
			bankManagement();
		}
	}

	private void secondMenu(String ans2) {
		ans2 = ans2.toLowerCase();
		
		switch(ans2) {
			case "a":
				customerMenu();
				break;
			case "b":
				employeeMenu();
				break;
			case "c":
				adminMenu();
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again.");
				bankManagement();
				break;
		}
	}

	private void adminMenu() {
		System.out.println("What would you like to do?\n"+"[a] View Your Customers' Information\n"+"[b] Deposit\n"+"[c] Withdraw\n"+"[d] Transfer\n"
				+"[e] Approve Account\n"+"[f] Deny Account\n"+"[g] Close Account\n"+"[h] Exit");
		String adAns = scan.nextLine();
		adAns = adAns.toLowerCase();
		
		switch(adAns) {
			case "a":
				getAllCustInfo();
				getAllAcc();
				System.out.println("Would you like to do anything else?");
				adminMenu();
				break;
			case "b":
				try {
					depositIntoAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					adminMenu();
				}
				System.out.println("Would you like to do anything else?");
				adminMenu();
				break;
			case "c":
				try {
					withdrawFromAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					adminMenu();
				}
				System.out.println("Would you like to do anything else?");
				adminMenu();
				break;
			case "d":
				try {
					transferMoneyFromAcc1ToAcc2();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					adminMenu();
				}
				System.out.println("Would you like to do anything else?");
				adminMenu();
				break;
			case "e":
				try {
					approveAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					adminMenu();
				}
				System.out.println("Would you like to do anything else?");
				adminMenu();
				break;
			case "f":
				try {
					denyAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					adminMenu();
				}
				System.out.println("Would you like to do anything else?");
				adminMenu();
				break;
			case "g":
				try {
					closeAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					adminMenu();
				}
				System.out.println("Would you like to do anything else?");
				adminMenu();
				break;
			case "h":
				System.out.println("Thanks for ballin' with Little Baller Bank! Have a great day!");
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again.");
				adminMenu();
				break;
		}
		
	}

	private void closeAcc() {
		System.out.println("To ensure you can perform this type of action, please enter your user id.");
		int i1 = scan.nextInt();
		scan.nextLine();
		System.out.println("What is the id of the account you'd like to close?");
		int i2 = scan.nextInt();
		scan.nextLine();
		String stats = ao.closeAccount(i1, i2);
		
		System.out.println("The status of the account with id "+i2+" is now "+stats+".");
	}

	private void employeeMenu() {
		System.out.println("What would you like to do?\n"+"[a] View Your Customers' Information\n"+"[b] Approve Account\n"+"[c] Deny Account\n"
				+"[d] Exit");
		String empAns = scan.nextLine();
		empAns = empAns.toLowerCase();
		
		switch(empAns) {
			case "a":
				getAllCustInfo();
				getAllAcc();
				System.out.println("Would you like to do anything else?");
				employeeMenu();
				break;
			case "b":
				try {
					approveAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					employeeMenu();
				}
				System.out.println("Would you like to do anything else?");
				employeeMenu();
				break;
			case "c":
				try {
					denyAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					employeeMenu();
				}
				System.out.println("Would you like to do anything else?");
				employeeMenu();
				break;
			case "d":
				System.out.println("Thanks for ballin' with Little Baller Bank! Have a great day!");
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again.");
				employeeMenu();
				break;
		}
		
	}

	private void denyAcc() {
		System.out.println("To ensure you can perform this type of action, please enter your user id.");
		int i1 = scan.nextInt();
		scan.nextLine();
		System.out.println("What is the id of the account you'd like to deny?");
		int i2 = scan.nextInt();
		scan.nextLine();
		String stats = ao.denyAccount(i1, i2);
		
		System.out.println("The status of the account with id "+i2+" is now "+stats+".");
	}

	private void approveAcc() {
		System.out.println("To ensure you can perform this type of action, please enter your user id.");
		int i1 = scan.nextInt();
		scan.nextLine();
		System.out.println("What is the id of the account you'd like to approve?");
		int i2 = scan.nextInt();
		scan.nextLine();
		String stats = ao.approveAccount(i1, i2);
		
		System.out.println("The status of the account with id "+i2+" is now "+stats+".");
	}

	private void getAllAcc() {
		List<Account> allAcc = ao.getAllAccounts();
		System.out.println("Here are all the Accounts in the database:");
		for (Account a: allAcc) {
			System.out.println(a);
		}
	}

	private void getAllCustInfo() {
		List<User> customers = uo.getAllCustomers();
		System.out.println("Here are all the Customers in the database:");
		for (User u: customers) {
			System.out.println(u);
		}
	}

	private void customerMenu() {
		System.out.println("What would you like to do?\n"+"[a] View Your Accounts\n"+"[b] Deposit\n"+"[c] Withdraw\n"+"[d] Transfer\n"
				+"[e] Create a New Account\n"+"[f] Exit");
		String custAns = scan.nextLine();
		custAns = custAns.toLowerCase();
		
		switch(custAns) {
			case "a":
				try {
					viewAccByUserId();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					customerMenu();
				}
				System.out.println("Would you like to do anything else?");
				customerMenu();
				break;
			case "b":
				try {
					depositIntoAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					customerMenu();
				}
				System.out.println("Would you like to do anything else?");
				customerMenu();
				break;
			case "c":
				try {
					withdrawFromAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					customerMenu();
				}
				System.out.println("Would you like to do anything else?");
				customerMenu();
				break;
			case "d":
				try {
					transferMoneyFromAcc1ToAcc2();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					customerMenu();
				}
				System.out.println("Would you like to do anything else?");
				customerMenu();
				break;
			case "e":
				try {
					createNewAcc();
				} catch (InputMismatchException e) {
					System.out.println("Caught an InputMismatchException!");
					customerMenu();
				}
				System.out.println("Would you like to do anything else?");
				customerMenu();
				break;
			case "f":
				System.out.println("Thanks for ballin' with Little Baller Bank! Have a great day!");
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again.");
				customerMenu();
				break;
		}
		
	}

	private void createNewAcc() {
		System.out.println("What is your user ID?");
		int i = scan.nextInt();
		scan.nextLine();
		User u = uo.getUserById(i);
		System.out.println("What is the account type?");
		String type = scan.nextLine();
		System.out.println("What is the initial balance of the account?");
		double d = scan.nextDouble();
		scan.nextLine();
		System.out.println("Please set the status of your new account to 'Pending' until an employee or an admin can approve your account.");
		String stats = scan.nextLine();
		Account a = new Account(u, type, d, stats);
		
		if(ao.createNewAccount(a)) {
			System.out.println("Your account has been added to our database");
		} else {
			System.out.println("Something went wrong. Please try again.");
		}
	}

	private void viewAccByUserId() {
		System.out.println("What is your user ID connected to your accounts?");
		int iA = scan.nextInt();
		scan.nextLine();
		User u = uo.getUserById(iA);
		List<Account> custAccounts = ao.getAccountsByUserId(u);
		
		System.out.println("Here is your accounts: ");
		for(Account a: custAccounts) {
			System.out.println(a);
		}
	}

	private void transferMoneyFromAcc1ToAcc2() {
		System.out.println("What is the id of the first account?");
		int firstId = scan.nextInt();
		scan.nextLine();
		Account firstAcc = ao.getAccountById(firstId);
		System.out.println("What is the id of the second account?");
		int secondId = scan.nextInt();
		scan.nextLine();
		Account secondAcc = ao.getAccountById(secondId);
		System.out.println("What is the amount you are planning to transfer?");
		double transAmt = scan.nextDouble();
		scan.nextLine();
		double[] newAccBalances = ao.transferTo(firstId, secondId, transAmt);
		double newFirstAccBalance = newAccBalances[0];
		double newSecondAccBalance = newAccBalances[1];
		
		System.out.println("The new balance for the first account with id "+firstAcc.getAccountId()+" is "+newFirstAccBalance+".");
		System.out.println("The new balance for the second account with id "+secondAcc.getAccountId()+" is "+newSecondAccBalance+".");
	}

	private void withdrawFromAcc() {
		System.out.println("What is the ID of the account that you are trying to withdraw from?");
		int i = scan.nextInt();
		scan.nextLine();
		Account a = ao.getAccountById(i);
		System.out.println("How much would you like to withdraw?");
		double withAmt = scan.nextDouble();
		scan.nextLine();
		double newAccBalance = ao.withdraw(i, withAmt);
		
		System.out.println("The new balance for account with id "+a.getAccountId()+" is "+newAccBalance);
	}

	private void depositIntoAcc() {
		System.out.println("What is the ID of the account that you are trying to deposit into?");
		int i = scan.nextInt();
		scan.nextLine();
		Account a = ao.getAccountById(i);
		System.out.println("How much would you like to deposit?");
		double depoAmt = scan.nextDouble();
		scan.nextLine();
		double newAccBalance = ao.deposit(i, depoAmt);
		
		System.out.println("The new balance for account with id "+a.getAccountId()+" is "+newAccBalance);
	}

	private void logIn() {
		System.out.println("What is the id of the user you are trying to log in as?");
		int i = scan.nextInt();
		scan.nextLine();
		User u = uo.getUserById(i);
		System.out.println("What is your username?");
		String uName = scan.nextLine();
		System.out.println("What is your password?");
		String uPass = scan.nextLine();
		
		if (uo.logInUser(i, uName, uPass)) {
			System.out.println("Welcome back "+u.getFirstName()+" to Little Baller Bank!");
		} else {
			System.out.println("You may have typed something wrong. Please try again.");
			bankManagement();
		}
	}
	
	
}
