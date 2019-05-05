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
import com.form.ChangeUserInfoForm;

public class ChangeUserInfoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ChangeUserInfoForm changeUserInfoForm = (ChangeUserInfoForm) form;
		AccountBO accountBO = new AccountBO();

		if ("submit".equals(changeUserInfoForm.getSubmit())) {
			AcountUserTypeOfPeople userInfo = (AcountUserTypeOfPeople) request.getSession(true)
					.getAttribute("userInfo");
			String userId = userInfo.getUserid();
			String fullname = changeUserInfoForm.getFullname();
			int gender = changeUserInfoForm.getGender();
			String birthday = changeUserInfoForm.getBirthday();
			String address = changeUserInfoForm.getAddress();
			String cmnd = changeUserInfoForm.getCmnd();
			String mail = changeUserInfoForm.getMail();
			String phonenumber = changeUserInfoForm.getPhonenumber();
			String education = changeUserInfoForm.getEducation();

			accountBO.changeUserInfo(userId, fullname, gender, birthday, address, cmnd, mail, phonenumber, education);
			ActionMessages actionMessages = new ActionMessages();
			actionMessages.add("changeUserInfoSuccessMSG", new ActionMessage("mess.change.user.info.success"));
			saveMessages(request, actionMessages);
			return mapping.findForward("changeUserInfoSuccess");
		} else {
			return mapping.findForward("changeUserInfo");
		}

	}

}
