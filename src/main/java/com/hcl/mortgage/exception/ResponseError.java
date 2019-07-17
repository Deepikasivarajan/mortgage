package com.hcl.mortgage.exception;

import java.io.Serializable;

public class ResponseError implements Serializable {

	private static final long serialVersionUID = 1L;

	private String statusMessage;
	private Integer statusCode;

	public ResponseError(String statusMessage, Integer statusCode) {
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
