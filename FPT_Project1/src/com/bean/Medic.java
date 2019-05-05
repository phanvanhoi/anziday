package com.bean;

public class Medic {
	private int medicid;
	private String medicname;
	private String quantity;
	private String decription;
	private String typeofmedicid;
	private String warehouseid;
	private String warehousename;
	
	public String getWarehousename() {
		return warehousename;
	}
	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	public int getMedicid() {
		return medicid;
	}
	public void setMedicid(int medicid) {
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
	public Medic(int medicid, String medicname, String quantity, String decription, String typeofmedicid) {
		super();
		this.medicid = medicid;
		this.medicname = medicname;
		this.quantity = quantity;
		this.decription = decription;
		this.typeofmedicid = typeofmedicid;
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
	public Medic(){
		
	}
	@Override
	public String toString() {
		return ""+medicid+"------"+medicname+"------"+quantity+"------"+decription+"------"+typeofmedicid+"------"+warehousename+"------"+warehouseid;
	}
	
	
}
