package com.bo;

import java.util.ArrayList;
import java.util.List;

import com.bean.AddictMedicDetail;
import com.dao.AddictMedicDetailDAO;

public class AddictMedicDetailBO {
	AddictMedicDetailDAO dao = new AddictMedicDetailDAO();
	public ArrayList<AddictMedicDetail> getListAddict(){
		return dao.getListAddict();
	}
	public ArrayList<AddictMedicDetail> getListAddict(int row,int total){
		return dao.getListAddict(row, total);
	}
	public ArrayList<AddictMedicDetail> getListAddict(int row,int total,String key,String where){
		return dao.getListAddict(row, total, key, where);
	}
	
	public ArrayList<AddictMedicDetail> getListAddict(String key,String where){
		return dao.getListAddict(key, where);
	}
}

