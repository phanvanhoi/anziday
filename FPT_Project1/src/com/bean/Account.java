package com.bean;

public class Account {
	private String userid;
	private String username;
	private String password;
	private String typeid;
	private String status;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account(String userid, String username, String password, String typeid, String status) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.typeid = typeid;
		this.status = status;
	}

}
