package com.hcl.mortgage.dto;

import java.io.Serializable;

public class CustomerRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long customerId;
	private String customerName;

	public CustomerRequestDTO() {

	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
