package com.hcl.mortgage.exception;

import java.io.Serializable;

public class AccountNotFoundException extends RuntimeException implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "No accounts found";

	public AccountNotFoundException() {
		super(MESSAGE);

	}
}
