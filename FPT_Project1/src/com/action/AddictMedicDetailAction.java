package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.AddictMedicDetail;
import com.bo.AddictMedicDetailBO;
import com.form.ListAddictForm;

public class AddictMedicDetailAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			AddictMedicDetailBO addBO = new AddictMedicDetailBO();
			ArrayList<AddictMedicDetail> list=null;
			int row =1;
			// so luong record trong 1 table
			int total=5;
			ListAddictForm listAddictForm = (ListAddictForm) form;
			if(listAddictForm.getRow()!=null)
				row=Integer.parseInt(listAddictForm.getRow());
			if(listAddictForm.getSearch()!= null){
				 list = addBO.getListAddict(row,total,listAddictForm.getKeysearch(),listAddictForm.getWheresearch());
			}
			else{
				if(listAddictForm.getWheresearch() ==null){ 
					listAddictForm.setWheresearch("Addicts.AddictsID");
					listAddictForm.setKeysearch("");
					}
				list = addBO.getListAddict(row,total,listAddictForm.getKeysearch(),listAddictForm.getWheresearch());
			}
			// list = addBO.getListAddict(row,total);
			listAddictForm.setAddictlist(list);
			//System.out.println(list);
			
			//gui key + where search
			request.setAttribute("keysearch", listAddictForm.getKeysearch());
			request.setAttribute("wheresearch", listAddictForm.getWheresearch());
			//soluong record
			request.setAttribute("numberofrecord", addBO.getListAddict(listAddictForm.getKeysearch(),listAddictForm.getWheresearch()).size());
			return mapping.findForward("listAddict");
		}
	}
