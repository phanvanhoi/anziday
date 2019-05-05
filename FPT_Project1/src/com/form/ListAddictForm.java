package com.form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bean.AddictMedicDetail;

public class ListAddictForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addictsid;
	private String addictname;
	private String birthday;
	private String gender;
	private String addresses;
	private String relativesname;
	private String relationship;
	private String fullname;
	private String roomid;
	private String status;
	private String medicid;
	private ArrayList<AddictMedicDetail> addictlist;
	private String row;
	private String search;
	private String wheresearch;
	private String keysearch;
	public String getKeysearch() {
		return keysearch;
	}
	public void setKeysearch(String keysearch) {
		this.keysearch = keysearch;
	}
	public String getWheresearch() {
		return wheresearch;
	}
	public void setWheresearch(String wheresearch) {
		this.wheresearch = wheresearch;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public ArrayList<AddictMedicDetail> getAddictlist() {
		return addictlist;
	}
	public void setAddictlist(ArrayList<AddictMedicDetail> addictlist) {
		this.addictlist = addictlist;
	}
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMedicid() {
		return medicid;
	}
	public void setMedicid(String medicid) {
		this.medicid = medicid;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
