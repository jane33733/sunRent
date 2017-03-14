package com.sun.request.vo;

import com.sun.entity.BaseEntity;

public class LoginVO extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4186533726655407069L;
	
	private String account;
	private String password;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
