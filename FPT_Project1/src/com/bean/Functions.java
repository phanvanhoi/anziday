package com.bean;

public class Functions {
	private String functionid;
	private String functionname;
	private String typeid;
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
	public Functions(String functionid, String functionname, String typeid) {
		super();
		this.functionid = functionid;
		this.functionname = functionname;
		this.typeid = typeid;
	}
	public Functions(){
		
	}
}
