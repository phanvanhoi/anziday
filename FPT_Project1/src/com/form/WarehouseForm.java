package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.Warehouse;

public class WarehouseForm  extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String warehouseid;
	private String warehousename;
	private String decription;
	private List<Warehouse> listwarehouse;
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
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public List<Warehouse> getListwarehouse() {
		return listwarehouse;
	}
	public void setListwarehouse(List<Warehouse> listwarehouse) {
		this.listwarehouse = listwarehouse;
	}
	public WarehouseForm(String warehouseid, String warehousename, String decription, List<Warehouse> listwarehouse) {
		super();
		this.warehouseid = warehouseid;
		this.warehousename = warehousename;
		this.decription = decription;
		this.listwarehouse = listwarehouse;
	}
	public WarehouseForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
