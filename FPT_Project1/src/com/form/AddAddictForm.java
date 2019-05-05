package com.form;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bean.Room;
import com.bean.User;


public class AddAddictForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addictsid;
	private String addictname;
	private String birthday;
	private String gender;
	private String addresses;
	private String relativesid;
	private String relativesname;
	private String relationship;
	private String phonenumber;
	private String relativesaddress;
	private String userid;
	private String roomid;
	private String fullname;
	private String submit;
	private ArrayList<User> listdoctor;
	private ArrayList<Room> listroom;
	private String erraddictsid;
	public String getErraddictsid() {
		return erraddictsid;
	}
	public void setErraddictsid(String erraddictsid) {
		this.erraddictsid = erraddictsid;
	}
	public String getErrrelativesid() {
		return errrelativesid;
	}
	public void setErrrelativesid(String errrelativesid) {
		this.errrelativesid = errrelativesid;
	}
	private String errrelativesid;
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
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
	public String getRelativesaddress() {
		return relativesaddress;
	}
	public void setRelativesaddress(String relativesaddress) {
		this.relativesaddress = relativesaddress;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRoom() {
		return roomid;
	}
	public void setRoom(String room) {
		this.roomid = room;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public ArrayList<User> getListdoctor() {
		return listdoctor;
	}
	public void setListdoctor(ArrayList<User> listdoctor) {
		this.listdoctor = listdoctor;
	}
	public ArrayList<Room> getListroom() {
		return listroom;
	}
	public void setListroom(ArrayList<Room> listroom) {
		this.listroom = listroom;
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
