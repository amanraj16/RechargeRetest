package com.cg.mra.ui;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	private static Scanner scanner = new Scanner(System.in);//for inputting values
	private static AccountDao accountdao = new AccountDaoImpl();//
	private static AccountService accountService = new AccountServiceImpl(accountdao);

	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		int choice;
		while (true) {
			System.out.println("Select your choice from below");
			System.out.println("Press 1 to display Account balance");
			System.out.println("Press 2 to Recharge Account");
			System.out.println("Press 3 to Exit Application");
			System.out.println("Please Enter Your Choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: accountBalanceEnq();
				    break;
			case 2: rechargeAccount();
				    break;
			case 3: System.exit(0);
			default: System.out.println("SORRY...Wrong choice entered");
			}
		}

	}

	private static void accountBalanceEnq() {
		System.out.print("Enter Mobile No : ");
		String mobileNo = scanner.next();
		if(Pattern.matches("[6789]{1}[0-9]{9}",mobileNo))  
		{
			try {
				System.out.println("Your Current Balance is Rs. " + accountService.getAccountDetails(mobileNo).getAccountBalance());
				System.out.println();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
		else
			System.out.println("Enter valid 10 digit mobile number");
	}

	private static void rechargeAccount() {
		System.out.print("Enter Mobile No : ");
		String mobileNo = scanner.next();
		if(Pattern.matches("[6789]{1}[0-9]{9}",mobileNo))  
		{
			System.out.print("Enter Recharge Amount : ");
			double balance = scanner.nextDouble();
			if(balance>0)
			{
				try {
					if (accountService.rechargeAccount(mobileNo, balance) == 1.0) {
					System.out.println();
					System.out.println("Your Account Recharged Sucessfully");
					Account account = accountService.getAccountDetails(mobileNo);
					System.out.println("Hello " + account.getCustomerName() + ", Available Balance is Rs. " + account.getAccountBalance());
					}
					} catch (Exception e) {
							System.out.println(e.getMessage());
						}
			}
			else
				System.out.println("Recharge amount should be greater than 0");
		}
		else
			System.out.println("Enter valid 10 digit mobile number");
	}

}
