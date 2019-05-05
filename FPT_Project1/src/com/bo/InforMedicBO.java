package com.bo;

import java.util.List;

import com.bean.InforMedic;
import com.dao.InforMedicDAO;

public class InforMedicBO {
	
	InforMedicDAO inforMedicDAO = new InforMedicDAO();
	
	public List<InforMedic> getAllMedicInPrescrip(String id){
		return inforMedicDAO.getAllInforMedic(id);
	}
}
