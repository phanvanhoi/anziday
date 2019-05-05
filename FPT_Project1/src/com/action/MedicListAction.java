package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.TypeOfMedic;
import com.bean.Warehouse;
import com.bo.MedicBO;
import com.bo.TypeOfMedicBO;
import com.bo.WarehouseBO;
import com.form.CreateNewMedicForm;

public class MedicListAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CreateNewMedicForm createNewMedicAction = (CreateNewMedicForm) form;
		MedicBO medicBo = new MedicBO();
		createNewMedicAction.setListmedic(medicBo.getAllMedic());	
		WarehouseBO warehouseBo = new WarehouseBO();
		
		List<Warehouse> listWarehouse = warehouseBo.getListWarehouse();
		createNewMedicAction.setListwarehouse(listWarehouse);
		TypeOfMedicBO typebo = new  TypeOfMedicBO();
		return mapping.findForward("loadList");
	}
	
	
	
	
}
