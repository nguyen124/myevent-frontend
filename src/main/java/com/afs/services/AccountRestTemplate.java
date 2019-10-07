package com.afs.services;

import com.afs.model.Account;

public interface AccountRestTemplate {
	public boolean saveOrUpdateAccount(Account account);

	public Account[] getAccounts();

	public Account getAccount(Long accountNo);

	public int deleteAccount(Long accountNo);
}
