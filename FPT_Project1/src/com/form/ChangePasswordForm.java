package com.form;

public class ChangePasswordForm extends AccountForm{
	private String password;
	private String newpassword;
	private String newpasswordagain;
	private String submit;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getNewpasswordagain() {
		return newpasswordagain;
	}

	public void setNewpasswordagain(String newpasswordagain) {
		this.newpasswordagain = newpasswordagain;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
}
