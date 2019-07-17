package com.hcl.mortgage.exception;

import java.io.Serializable;

public class InvalidPhoneNumberException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Entered Phonenumber is Invalid";

	public InvalidPhoneNumberException() {
		super(MESSAGE);

	}

}
