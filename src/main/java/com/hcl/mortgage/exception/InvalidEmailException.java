package com.hcl.mortgage.exception;

import java.io.Serializable;

public class InvalidEmailException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Enter a valid Email";

	public InvalidEmailException() {
		super(MESSAGE);
	}
}
