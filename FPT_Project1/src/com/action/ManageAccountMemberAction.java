package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bo.AccountBO;
import com.form.AccountForm;

public class ManageAccountMemberAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("action!!!");
		AccountBO accountBO = new AccountBO();
		//AccountForm accountForm = new AccountForm();
		AccountForm accountForm = (AccountForm) form;
		accountForm.setListaccount(accountBO.listAccount());
		accountBO.writeFileJson();
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		return mapping.findForward("managerAcc");
	}

}
