package com.bean;

public class Addict {
	private String addictsid;
	private String addictname;
	private String birthday;
	private String gender;
	private String addresses;
	private String relativesid;
	private String relativesname;
	private String relationship;
	private String phonenumber;
	private String relativesaddress;
	private String room;
	private String doctor;
	@Override
	public String toString() {
		return addictsid+"\t"+addictname+"\t"+birthday+"\t"
				+gender+"\t"+addresses+"\t"+relativesid+"\t"+
				relativesname+"\t"+relationship+"\t"+
				phonenumber+"\t"+relativesaddress+"\t"+
				room+"\t"+doctor+"\n";
	}
	
	public Addict(String addictsid, String addictname, String birthday, String gender, String addresses,
			String relativesid, String relativesname, String relationship, String phonenumber, String relativesaddress,
			String room, String doctor) {
		super();
		this.addictsid = addictsid;
		this.addictname = addictname;
		this.birthday = birthday;
		this.gender = gender;
		this.addresses = addresses;
		this.relativesid = relativesid;
		this.relativesname = relativesname;
		this.relationship = relationship;
		this.phonenumber = phonenumber;
		this.relativesaddress = relativesaddress;
		this.room = room;
		this.doctor = doctor;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRelativesaddress() {
		return relativesaddress;
	}
	public void setRelativesaddress(String relativesaddress) {
		this.relativesaddress = relativesaddress;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getAddictsid() {
		return addictsid;
	}
	public void setAddictsid(String addictsid) {
		this.addictsid = addictsid;
	}
	public String getAddictname() {
		return addictname;
	}
	public void setAddictname(String addictname) {
		this.addictname = addictname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddresses() {
		return addresses;
	}
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}
	public String getRelativesid() {
		return relativesid;
	}
	public void setRelativesid(String relativesid) {
		this.relativesid = relativesid;
	}
	public String getRelativesname() {
		return relativesname;
	}
	public void setRelativesname(String relativesname) {
		this.relativesname = relativesname;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getRoom() {
		return room;
	}
	public void setRoomid(String room) {
		this.room = room;
	}
	public String getDoctorid() {
		return doctor;
	}
	public void setDoctorid(String doctor) {
		this.doctor = doctor;
	}
	public Addict(){

	}
}
