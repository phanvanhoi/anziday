package com.bo;

import java.util.List;

import com.bean.Prescrip;
import com.dao.PrescripDAO;

public class PrescripBO {
	PrescripDAO preDAO = new PrescripDAO();

	
	//get all prescrip with id
	public List<Prescrip> getPrescrip(String id){
		return preDAO.getAllPrescrip(id);
	}
	public List<Prescrip> getListPrescrip(){
		return preDAO.getListPrescrip();
	}
	
}
