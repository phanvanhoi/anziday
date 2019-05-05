package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bo.NotificationsBO;
import com.form.NotificationForm;

public class UpdateNotificationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		NotificationForm notificationForm = (NotificationForm) form;

		if ("submit".equals(notificationForm.getSubmit())) {
			NotificationsBO notificationsBO = new NotificationsBO();

			String notificationid = notificationForm.getNotificationid();
			String title = notificationForm.getTitle();
			String datecreate = notificationForm.getDatecreate();
			String content = notificationForm.getContent();

			notificationsBO.updateNotifications(notificationid, title, datecreate, content);
			ActionMessages actionMessages = new ActionMessages();;
			actionMessages.add("updateNotifySuccessMSG", new ActionMessage("mess.updatenotify.success"));
			saveMessages(request, actionMessages);
		}

		return mapping.findForward("updateNotificationSuccess");
	}

	public static void main(String[] args) {

	}

}
