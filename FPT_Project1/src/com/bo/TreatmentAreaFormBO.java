package com.bo;

import java.util.List;
import com.bean.TreatmentArea;
import com.dao.TreatmentAreaFormDAO;

public class TreatmentAreaFormBO {
	private static TreatmentAreaFormBO instance;
	TreatmentAreaFormDAO areaFormDAO = new TreatmentAreaFormDAO();
	public static TreatmentAreaFormBO getInstance(){
		if(instance == null){
			instance = new TreatmentAreaFormBO();
		}
		return instance;
	}
	public List<TreatmentArea> getAllTreatmentArea() {
		// TODO Auto-generated method stub
		return areaFormDAO.getAllTreatmentArea();
	}
	public String TreaName(String id) {
		// TODO Auto-generated method stub	Optional<TreatmentArea> result= getAllTreatmentArea().stream().filter(tr->tr.getTreatmentid().equals(id)).findFirst();
		return areaFormDAO.TreaName(id);
	}
}
