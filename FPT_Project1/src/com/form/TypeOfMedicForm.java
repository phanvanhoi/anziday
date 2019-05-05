package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.TypeOfMedic;

public class TypeOfMedicForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typeofmedicid;
	private String	typeofmedic;
	private String decription;
	private String warehouseid;
	private List<TypeOfMedic> listtypeofmedic;
	public String getTypeofmedicid() {
		return typeofmedicid;
	}
	public void setTypeofmedicid(String typeofmedicid) {
		this.typeofmedicid = typeofmedicid;
	}
	public String getTypeofmedic() {
		return typeofmedic;
	}
	public void setTypeofmedic(String typeofmedic) {
		this.typeofmedic = typeofmedic;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	public List<TypeOfMedic> getListtypeofmedic() {
		return listtypeofmedic;
	}
	public void setListtypeofmedic(List<TypeOfMedic> listtypeofmedic) {
		this.listtypeofmedic = listtypeofmedic;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TypeOfMedicForm(String typeofmedicid, String typeofmedic, String decription, String warehouseid,
			List<TypeOfMedic> listtypeofmedic) {
		super();
		this.typeofmedicid = typeofmedicid;
		this.typeofmedic = typeofmedic;
		this.decription = decription;
		this.warehouseid = warehouseid;
		this.listtypeofmedic = listtypeofmedic;
	}
	public TypeOfMedicForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
