package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.TypeOfMedic;
import com.bean.Warehouse;

import connection.DataAccess;

public class WarehouseDAO {
	DataAccess instanceSQL = DataAccess.getInstance();
	public List<Warehouse> getAllMedicTypeList(){
		List<Warehouse> listWarehouse = new ArrayList<Warehouse>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con.prepareStatement("select * From WareHouse");
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				Warehouse warehouse = new Warehouse();
				warehouse.setWarehouseid(rs.getString("WareHouseID"));
				warehouse.setWarehousename(rs.getString("WareHouseName"));
				warehouse.setDecription(rs.getString("Descrition"));
				listWarehouse.add(warehouse);
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
		return listWarehouse;
	}
	public static void main(String[] args) {
		WarehouseDAO a = new WarehouseDAO();

		List<Warehouse> ware = a.getAllMedicTypeList();
			for(Warehouse house : ware) {
				System.out.println(house.getWarehouseid());
			}
//		for(int i = 0;i <ware.size(); i++) {
//			System.out.println(ware.get(i).getWarehouseid());
//		}
	}
}
