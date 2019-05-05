package com.form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bean.Account;
import com.bean.User;

public class UserForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
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
	private String image;
	private String submit;
	private String password;
	private String passwordmk;
	private String username;
	private String typeid;
	private List<User> listUserss;
	private List<Account> listAccounts;
	
	public List<User> getListUsers() {
		return listUserss;
	}
	public void setListUsers(List<User> listUsers) {
		this.listUserss = listUsers;
	}
	public List<Account> getListAccounts() {
		return listAccounts;
	}
	public void setListAccounts(List<Account> listAccounts) {
		this.listAccounts = listAccounts;
	}
	public String getPasswordmk() {
		return passwordmk;
	}
	public void setPasswordmk(String passwordmk) {
		this.passwordmk = passwordmk;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}

	private List<User> listusers;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public List<User> getListusers() {
		return listusers;
	}
	public void setListusers(List<User> listusers) {
		this.listusers = listusers;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserForm(String userid, String fullname, int gender, String birthday, String position, String adress,
			String cmnd, String mail, String educationlevel, String coefficientsalary, String phonenumber,
			List<User> listusers) {
		super();
		this.userid = userid;
		this.fullname = fullname;
		this.gender = gender;
		this.birthday = birthday;
		this.position = position;
		this.adress = adress;
		this.cmnd = cmnd;
		this.mail = mail;
		this.educationlevel = educationlevel;
		this.coefficientsalary = coefficientsalary;
		this.phonenumber = phonenumber;
		this.listusers = listusers;
	}
	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.reset(mapping, request);
	}
	
	
}
