package com.form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bean.Medic;
import com.bean.TypeOfMedic;
import com.bean.Warehouse;

public class CreateNewMedicForm extends	ActionForm{
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
	private List<TypeOfMedic> listtypeofmedic;
	private String warehouseid;
	private String warehousename;
	private List<Warehouse> listwarehouse;
	private String	typeofmedic;
	private String submit;
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
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
	public List<TypeOfMedic> getListtypeofmedic() {
		return listtypeofmedic;
	}
	public void setListtypeofmedic(List<TypeOfMedic> listtypeofmedic) {
		this.listtypeofmedic = listtypeofmedic;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	public String getWarehousename() {
		return warehousename;
	}
	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}
	public List<Warehouse> getListwarehouse() {
		return listwarehouse;
	}
	public void setListwarehouse(List<Warehouse> listwarehouse) {
		this.listwarehouse = listwarehouse;
	}
	public String getTypeofmedic() {
		return typeofmedic;
	}
	public void setTypeofmedic(String typeofmedic) {
		this.typeofmedic = typeofmedic;
	}
	public CreateNewMedicForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	
	
	
}	
