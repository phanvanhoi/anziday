package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bean.AcountUserTypeOfPeople;
import com.bo.AccountBO;
import com.form.ChangePasswordForm;

public class ChangePasswordAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ChangePasswordForm changePasswordForm = (ChangePasswordForm) form;
		AccountBO accountBO = new AccountBO();

		if ("submit".equals(changePasswordForm.getSubmit())) {
			AcountUserTypeOfPeople userInfo = (AcountUserTypeOfPeople) request.getSession(false)
					.getAttribute("userInfo");
			String oldPassword = changePasswordForm.getPassword();
			String username = userInfo.getUsername();
			if (accountBO.checkAccount(username, oldPassword)) {
				String userID = userInfo.getUserid();
				String newPassword = changePasswordForm.getNewpassword();
				String newPasswordAgain = changePasswordForm.getNewpasswordagain();
				if (newPassword.toString().equals(newPasswordAgain.toString())) {
					if(accountBO.changePassword(userID, newPassword)) {
						ActionMessages actionMessages = new ActionMessages();
						actionMessages.add("changePasswordSuccessMSG", new ActionMessage("mess.changepassword.succes"));
						saveMessages(request, actionMessages);
					}
				}
			}
			return mapping.findForward("changePasswordSuccess");
		} else {
			return mapping.findForward("changePassword");
		}

	}

}
