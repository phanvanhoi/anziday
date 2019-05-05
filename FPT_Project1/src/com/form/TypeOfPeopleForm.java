package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.TypeOfPeople;

public class TypeOfPeopleForm  extends	ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typeid;
	private String typename;
	private List<TypeOfPeople> listtypeofpeople;
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public List<TypeOfPeople> getListtypeofpeople() {
		return listtypeofpeople;
	}
	public void setListtypeofpeople(List<TypeOfPeople> listtypeofpeople) {
		this.listtypeofpeople = listtypeofpeople;
	}
	public TypeOfPeopleForm(String typeid, String typename, List<TypeOfPeople> listtypeofpeople) {
		super();
		this.typeid = typeid;
		this.typename = typename;
		this.listtypeofpeople = listtypeofpeople;
	}
	public TypeOfPeopleForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
