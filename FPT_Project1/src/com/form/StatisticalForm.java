package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.*;

public class StatisticalForm extends ActionForm{

	
	private static final long serialVersionUID = 1L;

	private List<User> listUser;
	private List<Addict> listAddict;
	private List<TreatmentArea> listTreatmentArea;
	private List<Room> listRoom;
	private List<Medic> listMedic;
	private List<AddictsMedic> listAddictsMedic;
	private List<Notification> listNotification;
	public List<User> getListUser() {
		return listUser;
	}
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	public List<Addict> getListAddict() {
		return listAddict;
	}
	public void setListAddict(List<Addict> listAddict) {
		this.listAddict = listAddict;
	}
	public List<TreatmentArea> getListTreatmentArea() {
		return listTreatmentArea;
	}
	public void setListTreatmentArea(List<TreatmentArea> listTreatmentArea) {
		this.listTreatmentArea = listTreatmentArea;
	}
	public List<Room> getListRoom() {
		return listRoom;
	}
	public void setListRoom(List<Room> listRoom) {
		this.listRoom = listRoom;
	}
	public List<Medic> getListMedic() {
		return listMedic;
	}
	public void setListMedic(List<Medic> listMedic) {
		this.listMedic = listMedic;
	}
	public List<AddictsMedic> getListAddictsMedic() {
		return listAddictsMedic;
	}
	public void setListAddictsMedic(List<AddictsMedic> listAddictsMedic) {
		this.listAddictsMedic = listAddictsMedic;
	}
	public List<Notification> getListNotification() {
		return listNotification;
	}
	public void setListNotification(List<Notification> listNotification) {
		this.listNotification = listNotification;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public StatisticalForm(List<User> listUser, List<Addict> listAddict, List<TreatmentArea> listTreatmentArea,
			List<Room> listRoom, List<Medic> listMedic, List<AddictsMedic> listAddictsMedic,
			List<Notification> listNotification) {
		super();
		this.listUser = listUser;
		this.listAddict = listAddict;
		this.listTreatmentArea = listTreatmentArea;
		this.listRoom = listRoom;
		this.listMedic = listMedic;
		this.listAddictsMedic = listAddictsMedic;
		this.listNotification = listNotification;
	}
}
