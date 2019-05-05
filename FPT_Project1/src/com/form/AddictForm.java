package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.Addict;

public class AddictForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addictsid;
	private String addictname;
	private String gender;
	private String addresses;
	private String relativesid;
	private String relativesname;
	private String relationship;
	private String phonenumber;
	private String roomid;
	private String doctorid;
	private List<Addict> listaddict;
	public String getAddictsid() {
		return addictsid;
	}
	public void setAddictsid(String addictsid) {
		this.addictsid = addictsid;
	}
	public String getAddictname() {
		return addictname;
	}
	public void setAddictname(String addictname) {
		this.addictname = addictname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddresses() {
		return addresses;
	}
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}
	public String getRelativesid() {
		return relativesid;
	}
	public void setRelativesid(String relativesid) {
		this.relativesid = relativesid;
	}
	public String getRelativesname() {
		return relativesname;
	}
	public void setRelativesname(String relativesname) {
		this.relativesname = relativesname;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	public List<Addict> getListaddict() {
		return listaddict;
	}
	public void setListaddict(List<Addict> listaddict) {
		this.listaddict = listaddict;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public AddictForm(String addictsid, String addictname, String gender, String addresses, String relativesid,
			String relativesname, String relationship, String phonenumber, String roomid, String doctorid,
			List<Addict> listaddict) {
		super();
		this.addictsid = addictsid;
		this.addictname = addictname;
		this.gender = gender;
		this.addresses = addresses;
		this.relativesid = relativesid;
		this.relativesname = relativesname;
		this.relationship = relationship;
		this.phonenumber = phonenumber;
		this.roomid = roomid;
		this.doctorid = doctorid;
		this.listaddict = listaddict;
	}
	public AddictForm(){
		
	}
}
