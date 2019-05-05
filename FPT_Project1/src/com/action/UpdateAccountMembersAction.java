package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.Account;
import com.bo.AccountBO;
import com.form.AccountForm;

public class UpdateAccountMembersAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AccountForm accountForm = (AccountForm) form;
		AccountBO accountBO = new AccountBO();
		System.out.println(accountForm.getUserid());
		Account account = new Account(accountForm.getUserid(), accountForm.getUsername(), accountForm.getPassword(),
				accountForm.getTypeid(), accountForm.getStatus());
		if (accountForm.getBlock() != null) {
			accountBO.blockAccountMembers(accountForm.getUserid());
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			return mapping.findForward("manage-account");
		} else {
			accountBO.updateAccountMembers(account);
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			return mapping.findForward("manageAccount");
		}
	}

}
