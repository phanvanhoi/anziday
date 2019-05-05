package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.InforMedic;
import com.bean.Prescrip;

import connection.DataAccess;

public class InforMedicDAO {
	DataAccess instanceSQL = DataAccess.getInstance();
	
	//get all infor prescrip with id
	public List<InforMedic> getAllInforMedic(String id) {
		List<InforMedic> listInforMedic = new ArrayList<InforMedic>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {

			String sql = "Select * From InforMedic Where PrescripID = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, id);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				InforMedic infordic = new InforMedic();
				infordic.setInforMedicid(rs.getString("InforMedicID"));
				infordic.setPrescripid(rs.getString("PrescripID"));
				infordic.setMedicid(rs.getString("MedicID"));
				infordic.setNumpertime(rs.getString("NumPerTime"));
				infordic.setGuideline(rs.getString("Guideline"));
				listInforMedic.add(infordic);
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
		return listInforMedic;
	}
	public static void main(String[] args) {
		InforMedicDAO medao = new InforMedicDAO();
		List<InforMedic> lismedao =medao.getAllInforMedic("P01");
		for(InforMedic a : lismedao) {
			System.out.println(a.getMedicid());
		}
	}
}
