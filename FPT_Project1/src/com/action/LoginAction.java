package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bean.AcountUserTypeOfPeople;
import com.bo.AccountBO;
import com.common.PasswordEncryption;
import com.form.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		LoginForm loginForm = (LoginForm) form;
		AccountBO accountBO = new AccountBO();

		if ("submit".equals(loginForm.getSubmit())) {
			PasswordEncryption encryption = new PasswordEncryption();
			String username = loginForm.getUsername();
			String password = encryption.md5(loginForm.getPassword());
			if (accountBO.checkAccount(username, password)) {
				AcountUserTypeOfPeople userInfo = accountBO.getInfoUser(username, password);
				session.setAttribute("userInfo", userInfo);

				return mapping.findForward("loginSuccess");
			} else {
				ActionErrors actionErrors = new ActionErrors();
				actionErrors.add("loginFailMSG", new ActionMessage("error.login.fail"));
				saveErrors(request, actionErrors);
				if (actionErrors.size() > 0) {
					return mapping.findForward("loginFail");
				}
				return mapping.findForward("loginFail");
			}
		} else {
			return mapping.findForward("login");
		}
	}
}
