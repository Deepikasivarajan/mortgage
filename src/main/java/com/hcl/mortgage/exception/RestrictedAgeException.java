package com.hcl.mortgage.exception;

import java.io.Serializable;

public class RestrictedAgeException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Your Age is invalid";

	public RestrictedAgeException() {
		super(MESSAGE);

	}

}
