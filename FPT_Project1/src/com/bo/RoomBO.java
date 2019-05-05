package com.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Room;
import com.dao.RoomDAO;

public class RoomBO {
	private static RoomBO instance;
	RoomDAO roomDAO = new RoomDAO();

	public static RoomBO getInstance() {
		if (instance == null) {
			instance = new RoomBO();
		}
		return instance;
	}

	public boolean insertRoom(Room room) {
		// TODO Auto-generated method stub
		return roomDAO.insertRoom(room);
	}

	public List<Room> getAllRoom() {
		// TODO Auto-generated method stub
		return roomDAO.getAllRoom();
	}

	public boolean updateRoom(Room room) {
		return roomDAO.updateRoom(room);
	}

	public boolean deleteRoom(String id) {
		return roomDAO.deleteRoom(id);
	}

	public ArrayList<Room> getListRoom() throws SQLException {
		return roomDAO.getListRoom();
	}

}
