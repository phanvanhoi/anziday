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

public class DeleteNotificationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		NotificationForm notificationForm = (NotificationForm) form;
		
		if ("submit".equals(notificationForm.getSubmit())) {
			NotificationsBO notificationsBO = new NotificationsBO();
			String notificationid = notificationForm.getNotificationid();
			notificationsBO.deleteNotifications(notificationid);
			
			ActionMessages actionMessages = new ActionMessages();;
			actionMessages.add("deleteNotifySuccessMSG", new ActionMessage("mess.deletenotify.success"));
			saveMessages(request, actionMessages);
		}
		return mapping.findForward("deleteNotificationSuccess");
	}

	public static void main(String[] args) {

	}

}
