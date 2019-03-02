package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exceptions.AccountIdDoesNotExistException;

public interface AccountService {
	public Account getAccountDetails(String mobileNumber)  throws AccountIdDoesNotExistException;
	public double rechargeAccount(String mobileNumber,double rechargeAmount)  throws AccountIdDoesNotExistException;
}
