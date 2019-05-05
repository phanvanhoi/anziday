package com.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.bean.Room;
import com.bo.RoomBO;
import com.bo.StateRoomBO;
import com.bo.TreatmentAreaFormBO;
import com.form.RoomForm;

public class ActionRoom extends MappingDispatchAction {
	public ActionForward insertRoom(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RoomForm roomForm = (RoomForm) form;
		if(roomForm.getSubmit()!=null) {
			Room room = new Room();
			room.setRoomid(roomForm.getRoomid());
			room.setTreatmentid(roomForm.getState());
			room.setArea(roomForm.getArea());
			room.setNumberofbeds(roomForm.getNumberofbeds());
			room.setStateroomid(roomForm.getStateroom());
			room.setDecristion(roomForm.getDecristion());
			String sucess="Thêm phòng điều trị thành công";
			if(RoomBO.getInstance().insertRoom(room)){
				request.setAttribute("success", true);
				return mapping.findForward("Insert");
			}
			else{
				request.setAttribute("rooms", room);
				request.setAttribute("fail", true);
				return mapping.findForward("loadDrop");
			}
		}
			TreatmentAreaFormBO areaFormBO = TreatmentAreaFormBO.getInstance();
			StateRoomBO roomBO = StateRoomBO.getInstance();
	 		roomForm.setListTreatmentAreas(areaFormBO.getAllTreatmentArea());
	 		roomForm.setListStateRooms(roomBO.getAllTreatmentArea());
			return mapping.findForward("loadDrop");
	}
	public ActionForward showInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RoomForm form2 = (RoomForm)form;
		form2.setListRooms(RoomBO.getInstance().getAllRoom());
		return mapping.findForward("showinfoss");
	}
	public ActionForward updateRoom(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RoomForm form2 = (RoomForm)form;
		System.out.println(form2.getTreatmentid());
		if(form2.getSubmit()!=null) {
			Room room = new Room();
			room.setRoomid(form2.getRoomid());
			room.setTreatmentid(form2.getTreatmentid());
			room.setArea(form2.getArea());
			room.setNumberofbeds(form2.getNumberofbeds());
			room.setStateroomid(form2.getStateid());
			room.setDecristion(form2.getDecristion());
			if(RoomBO.getInstance().updateRoom(room)){
				return mapping.findForward("update");
				}
			return mapping.findForward("fail");
		}
		return mapping.findForward("fail");
	}
	public ActionForward deleteRoom(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RoomForm form2 = (RoomForm)form;
		System.out.println(form2.getRoomid());
		if(form2.getSubmit()!=null) {
			if(RoomBO.getInstance().deleteRoom(form2.getRoomid())){
				
				return mapping.findForward("deletes");
			}
			return mapping.findForward("fail");
		}
		return mapping.findForward("fail");
	}
}