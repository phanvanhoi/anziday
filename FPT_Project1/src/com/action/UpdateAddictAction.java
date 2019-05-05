package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.Addict;
import com.bean.Room;
import com.bean.User;
import com.bo.AddictBO;
import com.bo.RoomBO;
import com.bo.UserBO;
import com.form.AddAddictForm;

public class UpdateAddictAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		String id;
		if(request.getParameter("addictsid")!=null)
			id=request.getParameter("addictsid");
		else id=addAddictForm.getAddictsid();


		System.out.println("addAddictForm.getAddictsid(): "+addAddictForm.getAddictsid());
		System.out.println("ma:: "+request.getParameter("addictsid"));

		AddictBO addBO= new AddictBO();
		if(addAddictForm.getSubmit()==null){
		Addict addict = addBO.getAddict(id);
		addAddictForm.setAddictsid(id);
		addAddictForm.setAddictname(addict.getAddictname());
		addAddictForm.setBirthday(addict.getBirthday());
		addAddictForm.setGender(addict.getGender());
		addAddictForm.setAddresses(addict.getAddresses());
		addAddictForm.setRelativesid(addict.getRelativesid());
		addAddictForm.setRelativesname(addict.getRelativesname());
		addAddictForm.setRelationship(addict.getRelationship());
		addAddictForm.setPhonenumber(addict.getPhonenumber());
		addAddictForm.setRelativesaddress(addict.getRelativesaddress());
		addAddictForm.setRoom(addict.getRoom());
		addAddictForm.setFullname(addict.getDoctor());
		}
		System.out.println("123123123123"+addAddictForm.getSubmit());
		if(addAddictForm.getSubmit()!=null)
			if(addAddictForm.getSubmit().equals("submit"))
			{
				System.out.println("quoc");
				addBO.updateAddict(id,addAddictForm.getAddictname(), addAddictForm.getBirthday(), 
						addAddictForm.getGender(), addAddictForm.getAddresses(), addAddictForm.getRelativesid(), 
						addAddictForm.getRelativesname(), addAddictForm.getRelationship(), 
						addAddictForm.getPhonenumber(), addAddictForm.getRelativesaddress(), addAddictForm.getRoom(), addAddictForm.getFullname());
					System.out.println("update xong");
				return mapping.findForward("updateFinish");
			}
		return mapping.findForward("updateAddict");
	}

}
