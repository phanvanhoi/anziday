package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.AddictsMedic;

public class AddictsMedicForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addictsid;
	private String medicid;
	private String quanlity;
	private String status;
	private List<AddictsMedic> listaddictsmedic;
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
	public List<AddictsMedic> getListaddictsmedic() {
		return listaddictsmedic;
	}
	public void setListaddictsmedic(List<AddictsMedic> listaddictsmedic) {
		this.listaddictsmedic = listaddictsmedic;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public AddictsMedicForm(String addictsid, String medicid, String quanlity, String status,
			List<AddictsMedic> listaddictsmedic) {
		super();
		this.addictsid = addictsid;
		this.medicid = medicid;
		this.quanlity = quanlity;
		this.status = status;
		this.listaddictsmedic = listaddictsmedic;
	}
	public AddictsMedicForm(){
		
	}

}
