package com.bo;

import java.util.List;

import com.bean.Addict;
import com.dao.AddictsDAO;

public class AddictBO {
	AddictsDAO dao = new AddictsDAO();
	public void insertAddict(String addictsid,String addictname,String birthday,String gender,String addresses,String relativesid,String relativesname,String relationship,String phonenumber,String relativesaddress,String room,String doctor){
		dao.insertAddict(addictsid, addictname, birthday, gender, addresses, relativesid, relativesname, relationship, phonenumber, relativesaddress, room, doctor);
	}
	public List<String> getAddictCode(){
		return dao.getAddictCode();
	}
	
	public boolean isExitAddictID(String id){
		return dao.isExitAddictID(id);
	}
	
	public boolean isExitRelativesId(String id){
		return dao.isExitRelativesId(id);
	}
	public Addict getAddict(String id)
	{
		return dao.getAddict(id);
	}
	public void updateAddict(String addictsid, String addictname, String birthday, String gender, String addresses,
			String relativesid, String relativesname, String relationship, String phonenumber, String relativesaddress,
			String roomid, String doctor){
		dao.updateAddict(addictsid, addictname, birthday, gender, addresses, relativesid, relativesname, relationship, phonenumber, relativesaddress, roomid, doctor);
	}
	public void deleteAddict(String id){
		dao.deleteAddict(id);
	}
}
