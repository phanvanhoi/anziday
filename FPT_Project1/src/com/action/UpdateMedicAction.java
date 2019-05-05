package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.Medic;
import com.bean.Warehouse;
import com.bo.MedicBO;
import com.bo.WarehouseBO;
import com.form.CreateNewMedicForm;

public class UpdateMedicAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		CreateNewMedicForm creatNewMedicForm = (CreateNewMedicForm) form;
		MedicBO medicbo = new MedicBO();
		Medic medic = new Medic();
		System.out.println(creatNewMedicForm.getTypeofmedicid());
		medic.setMedicid(Integer.parseInt(creatNewMedicForm.getMedicid()));
		medic.setMedicname(creatNewMedicForm.getMedicname());
		medic.setQuantity(creatNewMedicForm.getQuantity());
		medic.setDecription(creatNewMedicForm.getDecription());
		medic.setTypeofmedicid(creatNewMedicForm.getTypeofmedicid());
		medic.setWarehouseid(creatNewMedicForm.getWarehouseid());
		System.out.println(medic.getMedicid()+medic.getTypeofmedicid()+medic.getMedicname());
		if(medicbo.updateMedic(medic)==1) {
			return mapping.findForward("updateSuscess");
		}
		else {
			System.out.println("looi");
			return mapping.findForward("updateError");
		}
	}
}
