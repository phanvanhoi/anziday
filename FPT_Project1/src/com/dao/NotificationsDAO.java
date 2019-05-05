package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Notification;

import connection.DataAccess;

public class NotificationsDAO {
	DataAccess instanceSQL = DataAccess.getInstance();

	public List<Notification> getNotifications() {
		ResultSet rs = null;
		Connection con = instanceSQL.createConnection();
		String query = "SELECT * FROM Notifications";
		Statement statement;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		List<Notification> list = new ArrayList<>();
		Notification notification = null;
		try {
			while (rs.next()) {
				notification = new Notification();
				notification.setNotificationid(rs.getString("NotificationID"));
				notification.setTitle(rs.getString("Title"));
				notification.setDatecreate(rs.getString("DateCreate"));
				notification.setContent(rs.getString("Content"));
				list.add(notification);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return list;
	}

	public boolean deleteNotification(String notificationid) throws SQLException {
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();

		String query = "DELETE FROM Notifications WHERE NotificationID = ?";
		try {
			preStm = con.prepareStatement(query);
			preStm.setString(1, notificationid);
			if (preStm.executeUpdate() >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preStm != null) {
				preStm.close();
			}
		}
	}

	public boolean insertNotification(String title, String datecreate, String content, String managerid) throws SQLException {
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();

		String query = "INSERT INTO Notifications(Title, DateCreate, Content, ManagerID) VALUES(?,?,?,?)";

		try {
			preStm = con.prepareStatement(query);
			preStm.setString(1, title);
			preStm.setString(2, datecreate);
			preStm.setString(3, content);
			preStm.setString(4, managerid);
			if (preStm.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preStm != null) {
				preStm.close();
			}
		}
	}

	public boolean updateNotification(String notificationid, String title, String datecreate, String content)
			throws SQLException {
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();

		String query = "UPDATE Notifications SET Title = ?, DateCreate = ?, Content = ? WHERE NotificationID = ?";
		try {
			preStm = con.prepareStatement(query);
			preStm.setString(1, title);
			preStm.setString(2, datecreate);
			preStm.setString(3, content);
			preStm.setString(4, notificationid);
			if (preStm.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preStm != null) {
				preStm.close();
			}
		}
	}

	public static void main(String[] args) {
		NotificationsDAO dao = new NotificationsDAO();
		try {
			dao.insertNotification("Hello", "Hello", "Hello", "Hello");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
