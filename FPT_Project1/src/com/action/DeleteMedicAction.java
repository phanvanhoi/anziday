package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bo.MedicBO;
import com.form.CreateNewMedicForm;

public class DeleteMedicAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CreateNewMedicForm createNewMedic = (CreateNewMedicForm) form;
		MedicBO mebo = new MedicBO();
		int id = Integer.parseInt(createNewMedic.getMedicid());
		System.out.println(id);
		int kq = mebo.deleteMedic(id);
		return kq==1 ? mapping.findForward("deleteSucess") : mapping.findForward("deleteError");
		
	}
	
}
