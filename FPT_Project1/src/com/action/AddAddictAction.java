package com.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.Room;
import com.bean.User;
import com.bo.AddictBO;
import com.bo.RoomBO;
import com.bo.UserBO;
import com.form.AddAddictForm;

public class AddAddictAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AddAddictForm addAddictForm = (AddAddictForm) form;
		//get list doctor
		UserBO usBO = new UserBO();
		ArrayList<User> listDoctor = usBO.ListNamePeople(2);
		addAddictForm.setListdoctor(listDoctor);
		//get list room
		RoomBO roomBO = new RoomBO();
		ArrayList<Room> listRoom = roomBO.getListRoom();
		addAddictForm.setListroom(listRoom);
		if("submit".equals(addAddictForm.getSubmit())){ //click submit button on add addict page
			System.out.println("submit");
			AddictBO addict = new AddictBO();
			//check trung ma con nghien
			if(addict.isExitAddictID(addAddictForm.getAddictsid().trim()) || addict.isExitRelativesId(addAddictForm.getRelativesid())){
				if(addict.isExitAddictID(addAddictForm.getAddictsid().trim()))
					addAddictForm.setErraddictsid(
							"<div class=\"sufee-alert alert with-close alert-danger alert-dismissible fade show\">"
							+"<span class=\"badge badge-pill badge-danger\">Error</span>"
							+ "ID "+addAddictForm.getAddictsid().trim()+" đã tồn tại, vui lòng chọn ID khác!!!"
							+"<button type=\"button\" class=\"close\" data-dismiss=\"alert aria-label=\"Close\">"	
							+"<span aria-hidden=\"true\">×</span> </button> </div>");
				
				//check trung ma nguoi than
				if(addict.isExitRelativesId(addAddictForm.getRelativesid()))
					addAddictForm.setErrrelativesid("Mã người thân "+addAddictForm.getRelativesid()+" đã tồn tại, vui lòng chọn mã khác!!!");
				return mapping.findForward("addAddict");
			}
			addict.insertAddict(addAddictForm.getAddictsid().trim(), 
					addAddictForm.getAddictname().trim(), addAddictForm.getBirthday(), 
					addAddictForm.getGender().trim(), addAddictForm.getAddresses().trim(), 
					addAddictForm.getRelativesid().trim(), addAddictForm.getRelativesname().trim(), 
					addAddictForm.getRelationship(), addAddictForm.getPhonenumber(), 
					addAddictForm.getRelativesaddress().trim(), addAddictForm.getRoom(), 
					addAddictForm.getFullname());
			return mapping.findForward("addAddictFinish");
		}
		else System.out.println("eo submit");
		return mapping.findForward("addAddict");
	}
}
