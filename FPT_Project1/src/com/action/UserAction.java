package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bo.UserBO;
import com.form.AcountUserTypeOfPeopleForm;

public class UserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AcountUserTypeOfPeopleForm userForm = (AcountUserTypeOfPeopleForm) form;
		UserBO userBO = new UserBO();

		userForm.setUserlist(userBO.getUsers());
		return mapping.findForward("viewUserListSuccess");
	}

}
