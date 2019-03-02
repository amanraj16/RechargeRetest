package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.exceptions.AccountIdDoesNotExistException;

public class AccountServiceImpl implements AccountService {

	public AccountServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	AccountDao accountdao;
	
	public AccountServiceImpl(AccountDao accountdao) {
		super();
		this.accountdao = accountdao;
	}

	@Override
	public Account getAccountDetails(String mobileNumber) throws AccountIdDoesNotExistException {
		Account account = accountdao.getAccountDetails(mobileNumber);
		if(account==null) {
			throw new AccountIdDoesNotExistException("ERROR: Given Account Id Does Not Exist");
		}
		return account;
	}

	@Override
	public double rechargeAccount(String mobileNumber, double rechargeAmount) throws AccountIdDoesNotExistException  {
		Account account = accountdao.getAccountDetails(mobileNumber);
		if(account!=null) {
			return accountdao.rechargeAccount(mobileNumber, rechargeAmount);
		}
		throw new AccountIdDoesNotExistException("ERROR: Cannot Recharge Account as Given Mobile No Does Not Exist");
	}

}
