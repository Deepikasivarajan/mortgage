package com.hcl.mortgage.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String loginId;
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
