package com.bean;

public class Notification {
	private String notificationid;
	private String title;
	private String datecreate;
	private String content;
	private String managerid;
	public String getNotificationid() {
		return notificationid;
	}
	public void setNotificationid(String notificationid) {
		this.notificationid = notificationid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getManagerid() {
		return managerid;
	}
	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public Notification(){
		
	}
	public Notification( String title, String datecreate, String content, String managerid) {
		super();

		this.title = title;
		this.datecreate = datecreate;
		this.content = content;
		this.managerid = managerid;
	}
	
}
