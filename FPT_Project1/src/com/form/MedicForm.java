package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.Medic;

public class MedicForm extends	ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String medicid;
	private String medicname;
	private String quantity;
	private String decription;
	private String typeofmedicid;
	private List<Medic> listmedic;
	public String getMedicid() {
		return medicid;
	}
	public void setMedicid(String medicid) {
		this.medicid = medicid;
	}
	public String getMedicname() {
		return medicname;
	}
	public void setMedicname(String medicname) {
		this.medicname = medicname;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getTypeofmedicid() {
		return typeofmedicid;
	}
	public void setTypeofmedicid(String typeofmedicid) {
		this.typeofmedicid = typeofmedicid;
	}
	public List<Medic> getListmedic() {
		return listmedic;
	}
	public void setListmedic(List<Medic> listmedic) {
		this.listmedic = listmedic;
	}
	public MedicForm(){
		
	}
	public MedicForm(String medicid, String medicname, String quantity, String decription, String typeofmedicid,
			List<Medic> listmedic) {
		super();
		this.medicid = medicid;
		this.medicname = medicname;
		this.quantity = quantity;
		this.decription = decription;
		this.typeofmedicid = typeofmedicid;
		this.listmedic = listmedic;
	}
	
}	
