package com.cg.mra.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exceptions.AccountIdDoesNotExistException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class TestMRA {
	private static AccountDao accountdao = new AccountDaoImpl();
	private static AccountService accountService = new AccountServiceImpl(accountdao);
	@Test(expected=com.cg.mra.exceptions.AccountIdDoesNotExistException.class)
	public void whenAccountIdDoesNotExistWhileRecharging() throws AccountIdDoesNotExistException {
		accountService.rechargeAccount("7060608501",200);
	}
	@Test(expected=com.cg.mra.exceptions.AccountIdDoesNotExistException.class)
	public void whenwhenAccountIdDoesNotExistWhileShowingBalance() throws AccountIdDoesNotExistException
	{
		accountService.getAccountDetails("7599260545");
	}
	@Test
	public void successfullyRechargedAccountOnEnteringValidMobileNumber() throws AccountIdDoesNotExistException
	{
		accountService.rechargeAccount("9010210131",200);
		assertEquals(400,accountService.getAccountDetails("9010210131").getAccountBalance(),0.01);
	}
	
		
	
	@Test
	public void showAccountBalanceOnEnteringValidMobileNumber() throws AccountIdDoesNotExistException
	{
		accountService.getAccountDetails("9932012345");
		assertEquals(631,accountService.getAccountDetails("9932012345").getAccountBalance(),0.01);
	}
}
