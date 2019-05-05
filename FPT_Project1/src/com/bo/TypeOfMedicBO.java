package com.bo;

import java.util.List;

import com.bean.TypeOfMedic;
import com.dao.TypeOfMedicDAO;

public class TypeOfMedicBO {
	TypeOfMedicDAO typeOfMedicDao = new TypeOfMedicDAO();
	
	public List<TypeOfMedic> getTypeOfMedic(String id){
		return typeOfMedicDao.getAllMedicTypeList(id);
	}
}
