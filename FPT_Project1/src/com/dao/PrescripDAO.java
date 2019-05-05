package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Prescrip;

import connection.DataAccess;

public class PrescripDAO {
	
	DataAccess instanceSQL = DataAccess.getInstance();
	
	
	public List<Prescrip> getAllPrescrip(String id) {
		List<Prescrip> listPre = new ArrayList<Prescrip>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {

			String sql = "Select * From Prescrip Where AddictsID = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, id);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				Prescrip prescrip = new Prescrip();
				prescrip.setPrescripid(rs.getString("PrescripID"));
				prescrip.setAddictsid(rs.getString("AddictsID"));
				prescrip.setStartdate(rs.getString("StartDate"));
				prescrip.setEnddate(rs.getString("EndDate"));
				prescrip.setStatus(rs.getString("Statust"));
				listPre.add(prescrip);
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
		return listPre;
	}
	
	Connection sqlcon=null;
	PreparedStatement psttm=null;
	Statement sttm=null;
	ResultSet rs = null;
	public List<Prescrip> getListPrescrip(){
		List<Prescrip> arr = new ArrayList<Prescrip>();
		String sqlStr="select Prescrip.PrescripID,Addicts.AddictsName,Addicts.Room,Medic.MedicName,StartDate,Statust,Addicts.DocTor,Addicts.AddictsID "
				+ "from Prescrip full join Addicts on Prescrip.AddictsID = Addicts.AddictsID "
				+ "full join InforMedic on InforMedic.PrescripID = Prescrip.PrescripID "
				+ "full join Medic on Medic.MedicID = InforMedic.MedicID";
		sqlcon = instanceSQL.createConnection();
		try {
			sttm=sqlcon.createStatement();
			rs=sttm.executeQuery(sqlStr);
			Prescrip prescrip ;
			while(rs.next()){
				prescrip = new Prescrip(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
						arr.add(prescrip);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
}
