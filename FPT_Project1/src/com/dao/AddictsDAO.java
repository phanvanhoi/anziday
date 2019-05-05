package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Addict;
import com.common.RanDomObject;

import connection.DataAccess;

public class AddictsDAO {
	DataAccess instanceSQL = DataAccess.getInstance();
	Connection sqlcon = null;
	PreparedStatement psttm = null;
	Statement sttm = null;
	ResultSet rs = null;

	public void insertAddict(String addictsid, String addictname, String birthday, String gender, String addresses,
			String relativesid, String relativesname, String relationship, String phonenumber, String relativesaddress,
			String room, String doctor) {
		String sql = "insert into Addicts values(?,?,?,?,?,?,?,?,?,?,?,?)";
		sqlcon = instanceSQL.createConnection();
		try {
			psttm = sqlcon.prepareStatement(sql);
			psttm.setString(1, addictsid);
			psttm.setString(2, addictname);
			psttm.setString(3, birthday);
			psttm.setString(4, gender);
			psttm.setString(5, addresses);
			psttm.setString(6, relativesid);
			psttm.setString(7, relativesname);
			psttm.setString(8, relationship);
			psttm.setString(9, phonenumber);
			psttm.setString(10, relativesaddress);
			psttm.setString(11, room);
			psttm.setString(12, doctor);
			psttm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Addict> getListAddict() {
		List<Addict> arr = new ArrayList<Addict>();
		String sqlStr = "select * from Addicts";
		sqlcon = instanceSQL.createConnection();
		try {
			sttm = sqlcon.createStatement();
			rs = sttm.executeQuery(sqlStr);
			Addict addict;
			while (rs.next()) {
				addict = new Addict(rs.getString("AddictsID"), rs.getString("AddictsName"), rs.getString("Birthday"),
						rs.getString("Gender"), rs.getString("Addresses"), rs.getString("RelativesID"),
						rs.getString("RelativesName"), rs.getString("Relationship"), rs.getString("PhoneNumber"),
						rs.getString("RelativesAddress"), rs.getString("Room"), rs.getString("DocTor"));
				arr.add(addict);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}

	public Addict getAddict(String id) {
		Addict addict = null;
		String sqlStr = "select * from Addicts where AddictsID ='" + id + "'";
		sqlcon = instanceSQL.createConnection();
		try {
			sttm = sqlcon.createStatement();
			rs = sttm.executeQuery(sqlStr);

			while (rs.next()) {
				addict = new Addict(rs.getString("AddictsID"), rs.getString("AddictsName"), rs.getString("Birthday"),
						rs.getString("Gender"), rs.getString("Addresses"), rs.getString("RelativesID"),
						rs.getString("RelativesName"), rs.getString("Relationship"), rs.getString("PhoneNumber"),
						rs.getString("RelativeAddress"), rs.getString("Room"), rs.getString("DocTor"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addict;
	}

	public void updateAddict(String addictsid, String addictname, String birthday, String gender, String addresses,
			String relativesid, String relativesname, String relationship, String phonenumber, String relativesaddress,
			String roomid, String doctor) {
		String sqlStr = "update Addicts SET AddictsName=?,Birthday=?,Gender=?,Addresses=?,RelativesID=?,RelativesName=?,Relationship=?,PhoneNumber=?,RelativeAddress=?,Room=?,DocTor=? where AddictsID ='"
				+ addictsid + "'";
		sqlcon = instanceSQL.createConnection();
		try {
			psttm = sqlcon.prepareStatement(sqlStr);
			psttm.setString(1, addictname);
			psttm.setString(2, birthday);
			psttm.setString(3, gender);
			psttm.setString(4, addresses);
			psttm.setString(5, relativesid);
			psttm.setString(6, relativesname);
			psttm.setString(7, relationship);
			psttm.setString(8, phonenumber);
			psttm.setString(9, relativesaddress);
			psttm.setString(10, roomid);
			psttm.setString(11, doctor);
			psttm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getAddictCode() {
		List<String> arr = new ArrayList<String>();
		String sqlStr = "select AddictsID from Addicts";
		sqlcon = instanceSQL.createConnection();
		try {
			sttm = sqlcon.createStatement();
			rs = sttm.executeQuery(sqlStr);
			while (rs.next()) {
				arr.add(rs.getString("AddictsID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}

	public boolean isExitAddictID(String id) {
		String sqlStr = "select AddictsID from Addicts Where AddictsID='" + id + "'";
		sqlcon = instanceSQL.createConnection();
		try {
			sttm = sqlcon.createStatement();
			rs = sttm.executeQuery(sqlStr);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean isExitRelativesId(String id) {
		String sqlStr = "select AddictsID from Addicts Where RelativesId='" + id + "'";
		sqlcon = instanceSQL.createConnection();
		try {
			sttm = sqlcon.createStatement();
			rs = sttm.executeQuery(sqlStr);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void deleteAddict(String id) {
		String sqlStr = "delete InforMedic where InforMedic.PrescripID = (select Prescrip.PrescripID from Prescrip where Prescrip.AddictsID ='"
				+ id + "')" + "delete Prescrip where Prescrip.AddictsID ='" + id + "'"
				+ "delete Addicts where Addicts.AddictsID='" + id + "'";
		sqlcon = instanceSQL.createConnection();
		try {
			sttm = sqlcon.createStatement();
			sttm.executeQuery(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertListAddict(ArrayList<Addict> list) {
		String sql = "";
		for (int i = 0; i < list.size(); i++)
			sql += "insert into Addicts values(?,?,?,?,?,?,?,?,?,?,?,?) ";

		sqlcon = instanceSQL.createConnection();
		try {
			psttm = sqlcon.prepareStatement(sql);
			int k = 1;
			for(Addict a : list) {
				psttm.setString(k++, a.getAddictsid());
				psttm.setString(k++, a.getAddictname());
				psttm.setString(k++, a.getBirthday());
				psttm.setString(k++, a.getGender());
				psttm.setString(k++, a.getAddresses());
				psttm.setString(k++, a.getRelativesid());
				psttm.setString(k++, a.getRelativesname());
				psttm.setString(k++, a.getRelationship());
				psttm.setString(k++, a.getPhonenumber());
				psttm.setString(k++, a.getRelativesaddress());
				psttm.setString(k++, a.getRoom());
				psttm.setString(k++, a.getDoctor());
			}
			psttm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public void insertListAddict1(ArrayList<Addict> list) {
		
		insertAddict(addictsid, addictname, birthday, gender, addresses, relativesid, relativesname, relationship, phonenumber, relativesaddress, room, doctor);
	}*/

	public static void main(String[] args) {
		AddictsDAO r = new AddictsDAO();
		/*
		 * r.insertAddict("ID1", "Tên nè","2001-11-11", "nữ", "địa chỉ", "IDc",
		 * "RelativesName", "Relationship", "PhoneNumber","RelativesAddress", "room1",
		 * "doctor1"); List<Addict> list=r.getListAddict();
		 */
		ArrayList<Addict> list = new ArrayList<>();
		RanDomObject ranObject = new RanDomObject();
		Addict ad ;
		for(int i= 0; i< 100 ; i++) {
			ad=ranObject.randomAddict();
			list.add(ad);
			System.out.println(ad);
		}
		r.insertListAddict(list);
		
		System.out.println(r.getAddict("a"));
	}
}
