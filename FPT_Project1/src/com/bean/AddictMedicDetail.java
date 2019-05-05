package com.bean;

public class AddictMedicDetail {
	private String addictsid;
	private String addictname;
	private String birthday;
	private String gender;
	private String addresses;
	private String relativesname;
	private String relationship;
	private String fullname;
	private String roomid;
	private String status;
	private String prescripid;
	@Override
	public String toString() {
		return  addictsid +"\t"+  addictname+"\t"+  birthday+"\t"+  gender+"\t"+  addresses+"\t"+
				 relativesname+"\t"+  relationship+"\t"+  fullname+"\t"+ roomid+"\t"+  status+"\t"+  prescripid+"\n";
	}
	public AddictMedicDetail(String addictsid, String addictname, String birthday, String gender, String addresses,
			String relativesname, String relationship, String fullname, String roomid, String status, String medicid) {
		super();
		this.addictsid = addictsid;
		this.addictname = addictname;
		this.birthday = birthday;
		this.gender = gender;
		this.addresses = addresses;
		this.relativesname = relativesname;
		this.relationship = relationship;
		this.fullname = fullname;
		this.roomid = roomid;
		this.status = status;
		this.prescripid = medicid;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMedicid() {
		return prescripid;
	}
	public void setMedicid(String medicid) {
		this.prescripid = medicid;
	}
	
}
