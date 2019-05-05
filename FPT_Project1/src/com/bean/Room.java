package com.bean;

public class Room {
	private String roomid;
	private String treatmentid;
	private String numberofbeds;
	private String area;
	private String stateroomid;
	private String decristion;
	public String getStateroomid() {
		return stateroomid;
	}
	public void setStateroomid(String stateroomid) {
		this.stateroomid = stateroomid;
	}
	public String getDecristion() {
		return decristion;
	}
	public void setDecristion(String decristion) {
		this.decristion = decristion;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getTreatmentid() {
		return treatmentid;
	}
	public void setTreatmentid(String treatmentid) {
		this.treatmentid = treatmentid;
	}
	public String getNumberofbeds() {
		return numberofbeds;
	}
	public void setNumberofbeds(String numberofbeds) {
		this.numberofbeds = numberofbeds;
	}
	@Override
	public String toString() {
		return roomid+"\t"+treatmentid+"\t"+numberofbeds+"\t"+area+"\n";
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public Room(String roomid, String treatmentid, String numberofbeds, String area) {
		super();
		this.roomid = roomid;
		this.treatmentid = treatmentid;
		this.numberofbeds = numberofbeds;
		this.area = area;
	}
	public Room(){
		 
	}
}
