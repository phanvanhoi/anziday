package com.bo;

import java.sql.SQLException;
import java.util.List;

import com.bean.Notification;
import com.dao.NotificationsDAO;

public class NotificationsBO {
	NotificationsDAO notificationsDAO = new NotificationsDAO();

	public List<Notification> getNotifications() {
		return notificationsDAO.getNotifications();
	}

	public boolean deleteNotifications(String notificationid) {
		try {
			if (notificationsDAO.deleteNotification(notificationid)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateNotifications(String notificationid, String title, String datecreate, String content) {
		try {
			if (notificationsDAO.updateNotification(notificationid, title, datecreate, content)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertNotifications(String title, String datecreate, String content, String managerid) {
		try {
			if (notificationsDAO.insertNotification(title, datecreate, content, managerid)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		NotificationsBO bo = new NotificationsBO();
		bo.deleteNotifications("4");
	}
}
