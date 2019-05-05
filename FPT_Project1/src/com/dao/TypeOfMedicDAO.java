package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Medic;
import com.bean.TypeOfMedic;

import connection.DataAccess;

public class TypeOfMedicDAO {
	DataAccess instanceSQL = DataAccess.getInstance();
	public List<TypeOfMedic> getAllMedicTypeList(String id){
		List<TypeOfMedic> typeOfMedic = new ArrayList<TypeOfMedic>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con.prepareStatement("select * From TypeOfMedic Where WareHouseID = ?");
			preStm.setString(1, id);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				if(rs.getString("WareHouseID").equals(id)){
					TypeOfMedic typeofmedic = new TypeOfMedic();
					typeofmedic.setTypeofmedicid(rs.getString("TypeOfMedicID"));
					typeofmedic.setTypeofmedic(rs.getString("TypeOfMedicName"));
					typeofmedic.setDecription(rs.getString("Descrition"));
					typeofmedic.setWarehouseid(rs.getString("WareHouseID"));
					typeOfMedic.add(typeofmedic);
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
		return typeOfMedic;
	}
	public static void main(String[] args) {
		TypeOfMedicDAO typedao = new TypeOfMedicDAO();
		List<TypeOfMedic> aaaa= typedao.getAllMedicTypeList("KHO1");
		for(TypeOfMedic a: aaaa){
			System.out.println(a.getTypeofmedicid());
		}
	}
}
