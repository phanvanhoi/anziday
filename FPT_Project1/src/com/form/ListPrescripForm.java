package com.form;


import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.Prescrip;
public class ListPrescripForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Prescrip> listprescrip;
	public List<Prescrip> getListprescrip() {
		return listprescrip;
	}
	public void setListprescrip(List<Prescrip> listprescrip) {
		this.listprescrip = listprescrip;
	}
}
