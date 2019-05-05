package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bean.StateRoom;
import com.bean.TreatmentArea;
import com.bean.TypeOfMedic;

import connection.DataAccess;

public class StateRoomDAO {
	DataAccess instanceSQL = DataAccess.getInstance();
	public List<StateRoom> getAllStateRoom(){
		List<StateRoom> rooms = new ArrayList<>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con.prepareStatement("select * From StateRoom");
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				StateRoom room = new StateRoom();
				room.setStateid(rs.getString(1));
				room.setStatename(rs.getString(2));
				rooms.add(room);
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
		return rooms;
	}
	public String stateName(String id) {
		//return about Optional to use method get() or orElse getTreatmentname;
		Optional<StateRoom> result = getAllStateRoom().stream().filter(s->s.getStateid().equals(id)).findFirst();
		return result.orElse(null).getStatename();
	}
	public static void main(String[] args) {
		StateRoomDAO form = new StateRoomDAO();
		form.getAllStateRoom().stream().forEach(p->System.out.println(p.getStatename()));
		form.stateName("SR-01");
	}
}
