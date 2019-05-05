package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bean.TreatmentArea;
import com.bean.TypeOfMedic;

import connection.DataAccess;

public class TreatmentAreaFormDAO {
	DataAccess instanceSQL = DataAccess.getInstance();
	public List<TreatmentArea> getAllTreatmentArea(){
		List<TreatmentArea> treatmentAreas = new ArrayList<TreatmentArea>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con.prepareStatement("select * From TreatmentArea");
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				TreatmentArea treatmentArea = new TreatmentArea();
				treatmentArea.setTreatmentid(rs.getString(1));
				treatmentArea.setTreatmentname(rs.getString(2));
				treatmentAreas.add(treatmentArea);
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
		return treatmentAreas;
	}
	public String TreaName(String id) {
		//return about Optional to use method get() or orElse getTreatmentname;
		Optional<TreatmentArea> result = getAllTreatmentArea().stream().filter(tr->tr.getTreatmentid().equals(id)).findFirst();
		return result.orElse(null).getTreatmentname();
	}
	public static void main(String[] args) {
		TreatmentAreaFormDAO form = new TreatmentAreaFormDAO();
		form.getAllTreatmentArea().stream().forEach(p->System.out.println(p.getTreatmentname()));
	}
}
