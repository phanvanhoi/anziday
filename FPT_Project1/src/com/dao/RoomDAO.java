package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Room;
import com.bean.TreatmentArea;

import connection.DataAccess;

public class RoomDAO {
	DataAccess instanceSQL = DataAccess.getInstance();	
	
	public boolean insertRoom(Room room){
		boolean flag=false;
		List<TreatmentArea> treatmentAreas = new ArrayList<TreatmentArea>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		String sql="insert into Room values(?,?,?,?,?,?)";
		try {
			con.setAutoCommit(false);
			preStm=con.prepareStatement(sql);
			preStm.setNString(1,room.getRoomid());
			preStm.setNString(2,room.getTreatmentid());
			preStm.setNString(3,room.getArea());
			preStm.setNString(4,room.getNumberofbeds());
			preStm.setNString(5,room.getStateroomid());
			preStm.setNString(6,room.getDecristion());
			flag = preStm.executeUpdate()==1?true:false;
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(preStm!=null) {
				try {
					if(preStm!=null)preStm.close();
					if(con!=null)con.setAutoCommit(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					flag=false;
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	public List<Room> getAllRoom(){
		List<Room> listRooms = new ArrayList<>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con.prepareStatement("select * From Room");
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				Room room = new Room();
				room.setRoomid(rs.getString(1));
				room.setTreatmentid(rs.getString(2));
				room.setArea(rs.getString(3));
				room.setNumberofbeds(rs.getString(4));
				room.setStateroomid(rs.getString(5));
				room.setDecristion(rs.getString(6));
				listRooms.add(room);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (preStm != null) {
				try {
					preStm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listRooms;
	}
	public boolean updateRoom(Room room) {
		boolean flag = false;
		int kq=0;
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		String sql = "Select * from Room";
		try {
			preStm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				if (rs.getString("RoomID").equals(room.getRoomid())) {
					rs.updateString("TreatmentID",  room.getTreatmentid());
					rs.updateString("Area", room.getArea());
					rs.updateString("NumberOfBeds", room.getNumberofbeds());
					rs.updateString("stateID", room.getStateroomid());
					rs.updateString("Descrition", room.getDecristion());
					rs.updateRow();
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (preStm != null) {
				try {
					preStm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	public boolean deleteRoom(String id) {
		Connection con = null;
		int kq=0;
		boolean flag = false;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			con.setAutoCommit(false);
			preStm = con.prepareStatement("delete from Room where RoomID=?");
			preStm.setString(1,id);
			kq=preStm.executeUpdate();
			con.commit();
			flag = kq==1?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(preStm!=null) {
				try {
					if(preStm!=null)preStm.close();
					if(con!=null)con.setAutoCommit(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	public ArrayList<Room> getListRoom() throws SQLException {
		ArrayList<Room> list = new ArrayList<>();
		Connection con = instanceSQL.createConnection();
		Statement preStm = con.createStatement();
		String sql ="select * from Room";
		ResultSet rs =preStm.executeQuery(sql);
		Room room;
		while (rs.next()){
			room = new Room(rs.getString("RoomID"), rs.getString("TreatmentID"), rs.getString("Area"), rs.getString("NumberOfBeds"));
			list.add(room);
		}
		return list;
	}
}
