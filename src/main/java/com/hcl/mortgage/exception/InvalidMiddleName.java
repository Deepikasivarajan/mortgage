package com.hcl.mortgage.exception;

import java.io.Serializable;

public class InvalidMiddleName extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Entered middle name is invalid";

	public InvalidMiddleName() {
		super(MESSAGE);

	}

}
