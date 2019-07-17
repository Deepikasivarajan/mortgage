package com.hcl.mortgage.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class AccountRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long accountId;
	private String accountNumber;
	private String accountType;
	private Double balance;
	private LocalDate date;

	public AccountRequestDTO() {

	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
