package com.hcl.mortgage.dto;

import java.io.Serializable;

public class MortgageResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String loginId;
	private String password;
	private String mortgageNumber;
	private String customerName;
	private String accountNumber;

	public MortgageResponseDTO() {

	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMortgageNumber() {
		return mortgageNumber;
	}

	public void setMortgageNumber(String mortgageNumber) {
		this.mortgageNumber = mortgageNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
