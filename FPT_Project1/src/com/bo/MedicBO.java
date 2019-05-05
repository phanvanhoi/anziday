package com.bo;

import java.util.List;

import com.bean.Medic;
import com.dao.MedicDAO;

public class MedicBO {
	MedicDAO medicdao = new MedicDAO();
	public List<Medic> getAllMedic(){
		return medicdao.getAllMedic();
	}
	public int deleteMedic(int id){
		return medicdao.deleteMedic(id);
	}
	public int insertMedic(Medic medic){
		return medicdao.insertMedic(medic);
	}
	public Medic detailInforMedic(String id){
		return medicdao.detailInforMedic(id);
	}
	public int updateMedic(Medic medic){
		return medicdao.updateMedic(medic);
	}
	
	public List<Medic> searchType(String type, String data){
		return medicdao.searchMedic(type,data);
	}
	public String MedicName(int id) {
			return medicdao.MedicName(id);
		}
	public static void main(String[] args) {
		MedicBO mebo = new MedicBO();
		Medic medic = new Medic();
		medic.setMedicname("Thuoc Ho");
		medic.setQuantity("10");
		medic.setDecription("khong co");
		medic.setTypeofmedicid("DG");
		int kq = mebo.insertMedic(medic);
		System.out.println(kq);
	}
}
