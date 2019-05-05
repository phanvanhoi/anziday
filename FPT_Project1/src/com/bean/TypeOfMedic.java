package com.bean;

public class TypeOfMedic {
	private String typeofmedicid;
	private String	typeofmedic;
	private String decription;
	private String warehouseid;
	public TypeOfMedic(String typeofmedicid, String typeofmedic, String decription, String warehouseid) {
		super();
		this.typeofmedicid = typeofmedicid;
		this.typeofmedic = typeofmedic;
		this.decription = decription;
		this.warehouseid = warehouseid;
	}
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
	public TypeOfMedic(){
		
	}
	
}
