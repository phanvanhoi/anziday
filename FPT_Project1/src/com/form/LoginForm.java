package com.form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends	ActionForm{
	private String username;
	private String password;
	private String submit;
	private boolean remember;
	
	public LoginForm() {}

	public boolean isChecked() {
		return remember;
	}

	public void setChecked(boolean remember) {
		this.remember = remember;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	

}
