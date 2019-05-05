package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.Admin;

public class AdminForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String fullname;
	private String address;
	private int gender;
	private String birthday;
	private List<Admin> listadmin;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public List<Admin> getListadmin() {
		return listadmin;
	}
	public void setListadmin(List<Admin> listadmin) {
		this.listadmin = listadmin;
	}
	public AdminForm(String username, String password, String fullname, String address, int gender, String birthday,
			List<Admin> listadmin) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.gender = gender;
		this.birthday = birthday;
		this.listadmin = listadmin;
	}
	public AdminForm(){
		
	}
	
}
