package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.bean.Account;
import com.bean.User;
import com.bo.RoomBO;
import com.bo.UserBO;
import com.form.RoomForm;
import com.form.UserForm;

public class ActionUser extends MappingDispatchAction {

	public ActionForward insertUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserForm form2 =(UserForm)form;
		if(form2.getSubmit()!=null){
			Account account = new Account();
			if(UserBO.getInstance().duplicateId(form2.getUserid())) {
				request.setAttribute("errorUs", true);
				request.setAttribute("forms", form2);
				return mapping.findForward("loadPage");
			}
			account.setUserid(form2.getUserid());
			account.setUsername(form2.getUsername());
			account.setPassword(form2.getPassword());
			account.setTypeid(form2.getTypeid());
			User user = new User();
			user.setUserid(account.getUserid());
			user.setFullname(form2.getFullname());
			user.setGender(form2.getGender()+"");
			user.setPosition(form2.getPosition());
			user.setBirthday(form2.getBirthday());
			user.setAdress(form2.getAdress());
			user.setCmnd(form2.getCmnd());
			user.setMail(form2.getMail());
			user.setEducationlevel(form2.getEducationlevel());
			user.setCoefficientsalary(form2.getCoefficientsalary());
			user.setPhonenumber(form2.getPhonenumber());
			user.setImage(form2.getImage());
				if(UserBO.getInstance().insertAccount(account)){
					if(UserBO.getInstance().insertUser(user)){
						request.setAttribute("success", true);
						return mapping.findForward("Insert");
					}
					else {
						request.setAttribute("forms", form2);
						return mapping.findForward("loadPage");
					}
				}	
				else {
					request.setAttribute("forms", form2);
					request.setAttribute("errorN", true);
					return mapping.findForward("loadPage");
				}
			}
		return mapping.findForward("loadPage");
	}
	public ActionForward showInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserForm form2 = (UserForm)form;
		form2.setListusers(UserBO.getInstance().getAllUser());
		form2.setListAccounts(UserBO.getInstance().getAllAccount());
		request.setAttribute("listUser", UserBO.getInstance().getAllUser());
		return mapping.findForward("showinfoss");
	}
	public ActionForward UpdateInfoUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserForm form2 = (UserForm)form;
		if(form2.getSubmit()!=null){
			Account account = new Account();
			account.setUserid(form2.getUserid());
			account.setUsername(form2.getUsername());
			account.setTypeid(form2.getTypeid());
			User user = new User();
			user.setUserid(account.getUserid());
			user.setFullname(form2.getFullname());
			user.setGender(form2.getGender()+"");
			user.setPosition(form2.getPosition());
			user.setBirthday(form2.getBirthday());
			user.setAdress(form2.getAdress());
			user.setCmnd(form2.getCmnd());
			user.setMail(form2.getMail());
			user.setEducationlevel(form2.getEducationlevel());
			user.setCoefficientsalary(form2.getCoefficientsalary());
			user.setPhonenumber(form2.getPhonenumber());
			user.setImage(form2.getImage());
				if(UserBO.getInstance().updateAccount(account)){
					if(UserBO.getInstance().updateUser(user)){
						request.setAttribute("success", true);
						return mapping.findForward("update");
					}
				}	
				else {
					request.setAttribute("forms", form2);
					request.setAttribute("errorN", true);
					return mapping.findForward("loadPage");
				}
			}
		return mapping.findForward("showinfoss");
	}
	public ActionForward deleteInfoUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserForm form2 = (UserForm)form;
		if(form2.getSubmit()!=null){
			if(UserBO.getInstance().deleteUser(form2.getUserid())){
				return mapping.findForward("delete");
			}
			else
				return mapping.findForward("fail");
		}
		return mapping.findForward("fail");
	}
}
