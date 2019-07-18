package com.hcl.mortgage.exception;

import java.io.Serializable;

public class UserNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Please enter a valid credentials";

	public UserNotFoundException() {
		super(MESSAGE);
	}
}
