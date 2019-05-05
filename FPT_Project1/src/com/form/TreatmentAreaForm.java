package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.TreatmentArea;

public class TreatmentAreaForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String treatmentid;
	private String treatmentname;
	private String description;
	private List<TreatmentArea> listtreatmentarea;
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
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
	public List<TreatmentArea> getListtreatmentarea() {
		return listtreatmentarea;
	}
	public void setListtreatmentarea(List<TreatmentArea> listtreatmentarea) {
		this.listtreatmentarea = listtreatmentarea;
	}
	public TreatmentAreaForm(String treatmentid, String treatmentname, String description,
			List<TreatmentArea> listtreatmentarea) {
		super();
		this.treatmentid = treatmentid;
		this.treatmentname = treatmentname;
		this.description = description;
		this.listtreatmentarea = listtreatmentarea;
	}
	public TreatmentAreaForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
