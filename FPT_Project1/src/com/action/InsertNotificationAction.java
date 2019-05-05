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
import com.bo.NotificationsBO;
import com.common.RealtimeDatabse;
import com.form.NotificationForm;

public class InsertNotificationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		NotificationForm notificationForm = (NotificationForm) form;

		if ("submit".equals(notificationForm.getSubmit())) {
			NotificationsBO notificationsBO = new NotificationsBO();
			RealtimeDatabse databse = new RealtimeDatabse();
			AcountUserTypeOfPeople userInfo = (AcountUserTypeOfPeople) request.getSession(false)
					.getAttribute("userInfo");

			String title = notificationForm.getTitle();
			String datecreate = notificationForm.getDatecreate();
			String content = notificationForm.getContent();
			String managerid = userInfo.getUserid();

			notificationsBO.insertNotifications(title, datecreate, content, managerid);
			databse.insertNotification(title, datecreate, content, managerid);
			ActionMessages actionMessages = new ActionMessages();
			actionMessages.add("insertNotifySuccessMSG", new ActionMessage("mess.insertnotify.succes"));
			saveMessages(request, actionMessages);
			return mapping.findForward("insertNotificationSuccess");
		}else {
			return mapping.findForward("insertNotification");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
