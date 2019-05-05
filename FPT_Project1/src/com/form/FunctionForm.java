package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.Functions;

public class FunctionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String functionid;
	private String functionname;
	private String typeid;
	private List<Functions> listfunction;
	public String getFunctionid() {
		return functionid;
	}
	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}
	public String getFunctionname() {
		return functionname;
	}
	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public List<Functions> getListfunction() {
		return listfunction;
	}
	public void setListfunction(List<Functions> listfunction) {
		this.listfunction = listfunction;
	}
	public FunctionForm(String functionid, String functionname, String typeid, List<Functions> listfunction) {
		super();
		this.functionid = functionid;
		this.functionname = functionname;
		this.typeid = typeid;
		this.listfunction = listfunction;
	}
	public FunctionForm(){
		
	}
	
}
