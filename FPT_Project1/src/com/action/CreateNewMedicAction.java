package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bean.Medic;
import com.bean.TypeOfMedic;
import com.bean.Warehouse;
import com.bo.MedicBO;
import com.bo.TypeOfMedicBO;
import com.bo.WarehouseBO;
import com.form.CreateNewMedicForm;

public class CreateNewMedicAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		CreateNewMedicForm createNewMedicForm = (CreateNewMedicForm) form;
		MedicBO medicBo = new MedicBO();
		Medic medic;
		WarehouseBO warehouseBo = new WarehouseBO();
		List<Warehouse> listWarehouse = warehouseBo.getListWarehouse();
		createNewMedicForm.setListwarehouse(listWarehouse);

		if ("submit".equals(createNewMedicForm.getSubmit())) {
			medic = new Medic();
			medic.setMedicname(createNewMedicForm.getMedicname());
			medic.setQuantity(createNewMedicForm.getQuantity());
			medic.setDecription(createNewMedicForm.getDecription());
			medic.setTypeofmedicid(createNewMedicForm.getTypeofmedicid());
			System.out.println("aa"+medic.getDecription());
			ActionMessages actionMes = new ActionMessages();
			ActionErrors actionErr = new ActionErrors();
			if (medicBo.insertMedic(medic) == 1) {

				actionMes.add("insertSuccess", new ActionMessage("insert.medic.success"));
				saveMessages(request, actionMes);
				return mapping.findForward("createSucess");
			} else

			    actionMes.add("insertError", new ActionMessage("insert.medic.error"));
				saveErrors(request, actionMes);
				return mapping.findForward("createError");
		}
		return mapping.findForward("loadDrop");
	}

}
