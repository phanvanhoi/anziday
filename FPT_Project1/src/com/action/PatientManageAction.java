package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.Addict;
import com.bean.Medic;
import com.bo.AddictBO;
import com.bo.InforMedicBO;
import com.bo.MedicBO;
import com.bo.PrescripBO;
import com.form.PrescripManagementForm;

public class PatientManageAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		PrescripManagementForm prescripManageForm = (PrescripManagementForm) form;
		PrescripBO prescripBO = new PrescripBO();
		MedicBO mebo = new MedicBO();
		Addict addict;
		AddictBO addictBo = new AddictBO();
		String id = request.getParameter("addictsid"); 
		System.out.println(id);
		
		addict = addictBo.getAddict(id);
		
		System.out.println(addict.getAddictname());
		prescripManageForm.setAddictsid(addict.getAddictsid());
		prescripManageForm.setAddictname(addict.getAddictname());
		prescripManageForm.setBirthday(addict.getBirthday());
		prescripManageForm.setListpre(prescripBO.getPrescrip(id));
		/*prescripManageForm.setListinformedic(inforMedicBO.getAllMedicInPrescrip(prescriptid));*/
		prescripManageForm.setListmedic(mebo.getAllMedic());
		
		
		return mapping.findForward("loadList");
	}
	
	
	
	
	
	
}
