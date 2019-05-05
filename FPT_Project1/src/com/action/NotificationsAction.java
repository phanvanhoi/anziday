package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bo.NotificationsBO;
import com.form.NotificationForm;

public class NotificationsAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		NotificationForm notificationForm = (NotificationForm)form;
		NotificationsBO notificationsBO = new NotificationsBO();
		
		notificationForm.setListnotification(notificationsBO.getNotifications());
		return mapping.findForward("viewNotificationSuccess");
	}
	
}
