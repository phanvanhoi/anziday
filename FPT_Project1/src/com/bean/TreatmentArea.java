package com.bean;

public class TreatmentArea {
	private String treatmentid;
	private String treatmentname;
	private String description;
	public String getTreatmentid() {
		return treatmentid;
	}
	public void setTreatmentid(String treatmentid) {
		this.treatmentid = treatmentid;
	}
	public String getTreatmentname() {
		return treatmentname;
	}
	public void setTreatmentname(String treatmentname) {
		this.treatmentname = treatmentname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TreatmentArea(String treatmentid, String treatmentname, String description) {
		super();
		this.treatmentid = treatmentid;
		this.treatmentname = treatmentname;
		this.description = description;
	}
	public TreatmentArea(){
		
	}
}
