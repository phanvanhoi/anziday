package com.bean;

public class Prescrip {
	private String prescripid;
	private String addictsid;
	private String addictsnameid;
	private String addictsname;
	private String roomid;
	private String medicname;
	private String startdate;
	private String enddate;
	private String statust;
	private String doctor;
	public String getAddictsnameid() {
		return addictsnameid;
	}

	public void setAddictsnameid(String addictsnameid) {
		this.addictsnameid = addictsnameid;
	}
	
	public Prescrip(String prescripid, String addictsname, String roomid, String medicname,
			String startdate, String statust, String doctor, String addictsnameid) {
		super();
		this.prescripid = prescripid;
		this.addictsnameid = addictsnameid;
		this.addictsname = addictsname;
		this.roomid = roomid;
		this.medicname = medicname;
		this.startdate = startdate;
		this.statust = statust;
		this.doctor = doctor;
	}
	
	@Override
	public String toString() {
		return  addictsnameid+"\t"+prescripid +"\t"+  addictsname+"\t" + roomid+"\t" + medicname+"\t" + startdate+"\t" + statust+"\t" + doctor+"\n";
	}

	public String getPrescripid() {
		return prescripid;
	}
	public void setPrescripid(String prescripid) {
		this.prescripid = prescripid;
	}
	public String getAddictsid() {
		return addictsid;
	}
	public void setAddictsid(String addictsid) {
		this.addictsid = addictsid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return statust;
	}
	public void setStatus(String statust) {
		this.statust = statust;
	}

	public String getAddictsname() {
		return addictsname;
	}

	public void setAddictsname(String addictsname) {
		this.addictsname = addictsname;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getMedicname() {
		return medicname;
	}

	public void setMedicname(String medicname) {
		this.medicname = medicname;
	}

	public String getStatust() {
		return statust;
	}

	public void setStatust(String statust) {
		this.statust = statust;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Prescrip() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
