package com.afs.model;

import java.util.Date;

public class Account {

	private Long id;

	private String accountHolderName;

	private Integer balance;

	private Date dob;

	private String psCode;

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public Long getId() {
		return id;
	}

	public Integer getBalance() {
		return balance;
	}

	public Date getDob() {
		return dob;
	}

	public String getPsCode() {
		return psCode;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}

	@Override
	public String toString() {
		return String.format("{accountNo: %d, holder: %s}", this.id, this.accountHolderName);
	}
}
