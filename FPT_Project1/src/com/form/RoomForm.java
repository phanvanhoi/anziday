package com.form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bean.Room;
import com.bean.StateRoom;
import com.bean.TreatmentArea;

public class RoomForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stateid;
	private String stateroom;
	private String roomid;
	private String treatmentid;
	private String numberofbeds;
	private String area;
	private String decristion;
	private String submit;
	private List<TreatmentArea> listTreatmentAreas;
	private List<StateRoom> listStateRooms ;
	private List<Room> listRooms;
	
	public List<Room> getListRooms() {
		return listRooms;
	}
	public void setListRooms(List<Room> listRooms) {
		this.listRooms = listRooms;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getDecristion() {
		return decristion;
	}
	public void setDecristion(String decristion) {
		this.decristion = decristion;
	}
	public List<StateRoom> getListStateRooms() {
		return listStateRooms;
	}
	public void setListStateRooms(List<StateRoom> listStateRooms) {
		this.listStateRooms = listStateRooms;
	}
	private String state;
	
	public String getStateid() {
		return stateid;
	}
	public void setStateid(String stateid) {
		this.stateid = stateid;
	}
	public String getStateroom() {
		return stateroom;
	}
	public void setStateroom(String stateroom) {
		this.stateroom = stateroom;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<TreatmentArea> getListTreatmentAreas() {
		return listTreatmentAreas;
	}
	public void setListTreatmentAreas(List<TreatmentArea> listTreatmentAreas) {
		this.listTreatmentAreas = listTreatmentAreas;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getTreatmentid() {
		return treatmentid;
	}
	public void setTreatmentid(String treatmentid) {
		this.treatmentid = treatmentid;
	}
	public String getNumberofbeds() {
		return numberofbeds;
	}
	public void setNumberofbeds(String numberofbeds) {
		this.numberofbeds = numberofbeds;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public RoomForm(String roomid, String treatmentid, String numberofbeds, String area, List<Room> listroom) {
		super();
		this.roomid = roomid;
		this.treatmentid = treatmentid;
		this.numberofbeds = numberofbeds;
		this.area = area;
		this.listRooms = listroom;
	}
	public RoomForm() {
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.reset(mapping, request);
	}
	
	

}
