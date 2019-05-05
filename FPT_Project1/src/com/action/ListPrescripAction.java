package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bo.PrescripBO;
import com.form.ListPrescripForm;

public class ListPrescripAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrescripBO preBO = new PrescripBO();
		ListPrescripForm list = (ListPrescripForm) form;
		list.setListprescrip(preBO.getListPrescrip());
		System.out.println("alo "+preBO.getListPrescrip());
		return mapping.findForward("prescripList");
	}
	

}
