package com.hcl.mortgage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = { RestrictedAgeException.class })
	public ResponseEntity<ResponseError> ageException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { InvalidPhoneNumberException.class })
	public ResponseEntity<ResponseError> phoneException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { PropertyCostException.class })
	public ResponseEntity<ResponseError> propertyException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { AccountNotFoundException.class })
	public ResponseEntity<ResponseError> AccountNotFoundException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = { InvalidEmailException.class })
	public ResponseEntity<ResponseError> InvalidEmailException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { InvalidFirstName.class })
	public ResponseEntity<ResponseError> InvalidFirstName(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { InvalidMiddleName.class })
	public ResponseEntity<ResponseError> InvalidMiddleName(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { InvalidSurName.class })
	public ResponseEntity<ResponseError> InvalidSurName(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { UserNotFoundException.class })
	public ResponseEntity<ResponseError> UserNotFoundException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

}
