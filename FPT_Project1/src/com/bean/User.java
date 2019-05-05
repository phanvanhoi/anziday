package com.bean;

public class User {
	@Override
	public String toString() {
		return  userid +"\t"+ fullname+"\t"+gender+"\t"+ birthday+"\t"+ position+"\t"+ adress
				+"\t"+ cmnd+"\t"+ mail+"\t"+educationlevel+"\t"+coefficientsalary+"\t"+ phonenumber+"\n";
	}
	private String userid;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String fullname;
	private String gender;
	private String birthday;
	private String position;
	private String adress;
	private String cmnd;
	private String mail;
	private String educationlevel;
	private String coefficientsalary;
	private String phonenumber;
	private String image;
	private String typeid;
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
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
	public User(String userid, String fullname, String gender, String birthday, String position, String adress,
			String cmnd, String mail, String educationlevel, String coefficientsalary, String phonenumber) {
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
	}
	public User(){
		
	}
	
}
