package com.bean;

public class Warehouse {
	private String warehouseid;
	private String warehousename;
	private String decription;
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
	public Warehouse(String warehouseid, String warehousename, String decription) {
		super();
		this.warehouseid = warehouseid;
		this.warehousename = warehousename;
		this.decription = decription;
	}
	public Warehouse(){
		
	}
}
