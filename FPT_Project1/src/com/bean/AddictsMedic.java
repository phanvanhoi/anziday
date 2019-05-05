package com.bean;

public class AddictsMedic {
	private String addictsid;
	private String medicid;
	private String quanlity;
	public String getAddictsid() {
		return addictsid;
	}
	public void setAddictsid(String addictsid) {
		this.addictsid = addictsid;
	}
	public String getMedicid() {
		return medicid;
	}
	public void setMedicid(String medicid) {
		this.medicid = medicid;
	}
	public String getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(String quanlity) {
		this.quanlity = quanlity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;
	public AddictsMedic(String addictsid, String medicid, String quanlity, String status) {
		super();
		this.addictsid = addictsid;
		this.medicid = medicid;
		this.quanlity = quanlity;
		this.status = status;
	}
	public AddictsMedic(){
		
	}
	
}
