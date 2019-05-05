package com.form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bean.Notification;

public class NotificationForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String notificationid;
	private String title;
	private String datecreate;
	private String content;
	private String managerid;
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	private String submit;
	private List<Notification> listnotification;
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
	public List<Notification> getListnotification() {
		return listnotification;
	}
	public void setListnotification(List<Notification> listnotification) {
		this.listnotification = listnotification;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public NotificationForm(String notificationid, String title, String datecreate, String content, String managerid,
			List<Notification> listnotification) {
		super();
		this.notificationid = notificationid;
		this.title = title;
		this.datecreate = datecreate;
		this.content = content;
		this.managerid = managerid;
		this.listnotification = listnotification;
	}
	public NotificationForm(){
		
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.reset(mapping, request);
	}
	
	
}
