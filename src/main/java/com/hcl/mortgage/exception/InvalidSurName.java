package com.hcl.mortgage.exception;

import java.io.Serializable;

public class InvalidSurName extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Entered Surname is Invalid";

	public InvalidSurName() {
		super(MESSAGE);

	}

}
