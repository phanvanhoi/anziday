package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.AcountUserTypeOfPeople;

public class AcountUserTypeOfPeopleForm extends ActionForm{
	private String userid;
	private String username;
	private String password;
	private String typeid;
	private String fullname;
	private int gender;
	private String birthday;
	private String position;
	private String adress;
	private String cmnd;
	private String mail;
	private String educationlevel;
	private String coefficientsalary;
	private String phonenumber;
	private String typename;
	private List<AcountUserTypeOfPeople> userlist;

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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getEducationlevel() {
		return educationlevel;
	}

	public void setEducationlevel(String educationlevel) {
		this.educationlevel = educationlevel;
	}

	public String getCoefficientsalary() {
		return coefficientsalary;
	}

	public void setCoefficientsalary(String coefficientsalary) {
		this.coefficientsalary = coefficientsalary;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public List<AcountUserTypeOfPeople> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<AcountUserTypeOfPeople> userlist) {
		this.userlist = userlist;
	}
}
