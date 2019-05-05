package com.bo;

import java.util.List;

import com.bean.StateRoom;
import com.dao.StateRoomDAO;


public class StateRoomBO {
	private static StateRoomBO instance;
	StateRoomDAO areaFormDAO = new StateRoomDAO();
	public static StateRoomBO getInstance(){
		if(instance == null){
			instance = new StateRoomBO();
		}
		return instance;
	}
	public List<StateRoom> getAllTreatmentArea() {
		// TODO Auto-generated method stub
		return areaFormDAO.getAllStateRoom();
	}
	public String stateName(String id) {
		// TODO Auto-generated method stub	Optional<TreatmentArea> result= getAllTreatmentArea().stream().filter(tr->tr.getTreatmentid().equals(id)).findFirst();
		return areaFormDAO.stateName(id);
	}
	public static void main(String[] args) {
		StateRoomBO bo = new StateRoomBO();
		System.out.println(bo.stateName("SR-01"));
	}
}
