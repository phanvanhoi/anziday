package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Medic;

import connection.DataAccess;

public class MedicDAO {
	DataAccess instanceSQL = DataAccess.getInstance();
	List<Medic> listMedics;
	public MedicDAO() {
		listMedics = getAllMedic();
	}
	// insert medic
	public int insertMedic(Medic medic) {
		int kq = 0;
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con
					.prepareStatement("insert into Medic(MedicName,Quanlity,Descrition,TypeOfMedicID) values(?,?,?,?)");
			preStm.setString(1, medic.getMedicname());
			preStm.setString(2, medic.getQuantity());
			preStm.setString(3, medic.getDecription());
			preStm.setString(4, medic.getTypeofmedicid());
			kq = preStm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			kq = 0;
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

		return kq;
	}

	// get all medic from database
	public List<Medic> getAllMedic() {
		List<Medic> listMedic = new ArrayList<Medic>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			String sql = "select MedicID,MedicName,Quanlity,Medic.Descrition as Description,Medic.TypeOfMedicID,WareHouse.WareHouseID,WareHouseName"
					+ " From (Medic  inner join TypeOfMedic" + " ON (Medic.TypeOfMedicID = TypeOfMedic.TypeOfMedicID))"
					+ " inner join WareHouse" + " ON (TypeOfMedic.WareHouseID = WareHouse.WareHouseID)";

			preStm = con.prepareStatement(sql);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				Medic medic = new Medic();
				medic.setMedicid(rs.getInt("MedicID"));
				medic.setMedicname(rs.getString("MedicName"));
				medic.setQuantity(rs.getString("Quanlity"));
				medic.setDecription(rs.getString("Description"));
				medic.setTypeofmedicid(rs.getString("TypeOfMedicID"));
				medic.setWarehousename(rs.getString("Warehousename"));
				medic.setWarehouseid(rs.getString("WareHouseID"));
				listMedic.add(medic);
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
		return listMedic;
	}
	

	// delete medic with id
	public int deleteMedic(int id) {
		int kq = 0;
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con.prepareStatement("Delete From Medic Where MedicID =?");
			preStm.setInt(1, id);
			kq = preStm.executeUpdate();
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
		return kq;
	}

	// update Medic with id
	public int updateMedic(Medic medic) {
		int kq = 0;
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		String sql = "Select MedicID,MedicName,Quanlity, Descrition,TypeOfMedicID from Medic";
		System.out.println(medic);
		try {
			preStm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				if (rs.getInt("MedicID") == medic.getMedicid()) {
					rs.updateString("MedicName", medic.getMedicname());
					rs.updateString("Quanlity", medic.getQuantity());
					rs.updateString("Descrition", medic.getDecription());
					rs.updateString("TypeOfMedicID", medic.getTypeofmedicid());
					rs.updateRow();
					kq = 1;
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
		return kq;
	}

	// view detail information of medic
	public Medic detailInforMedic(String id) {
		Medic medic = new Medic();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		String sql = "Select * From Medic Where MedicID= ?";
		try {
			preStm = con.prepareStatement(sql);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				if (rs.getString("MedicID").equals(id)) {
					medic.setMedicid(rs.getInt("MedicID"));
					medic.setMedicname(rs.getString("MedicName"));
					medic.setQuantity(rs.getString("Quanlity"));
					medic.setDecription(rs.getString("Descrition"));
					medic.setTypeofmedicid(rs.getString("TypeOfMedicID"));
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
		return medic;
	}

	public List<Medic> searchMedic(String type, String data) {
		List<Medic> listMedic = new ArrayList<>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		String sql = "select MedicID,MedicName,Quanlity," + "Medic.Descrition as Description,"
				+ "Medic.TypeOfMedicID as TypeOfMedicID," + "WareHouse.WareHouseName as WareHouseName "
				+ "From Medic , WareHouse , TypeOfMedic  " + "Where (Medic.TypeOfMedicID=TypeOfMedic.TypeOfMedicID)"
				+ "and (TypeOfMedic.WareHouseID = WareHouse.WareHouseID)" + "and (" + type + "=?)";
		try {
			preStm = con.prepareStatement(sql);
			preStm.setString(1, data);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				Medic medic = new Medic();
				medic.setMedicid(rs.getInt("MedicID"));
				medic.setMedicname(rs.getString("MedicName"));
				medic.setQuantity(rs.getString("Quanlity"));
				medic.setDecription(rs.getString("Description"));
				medic.setTypeofmedicid(rs.getString("TypeOfMedicID"));
				medic.setWarehousename(rs.getString("WareHouseName"));
				listMedic.add(medic);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listMedic;
	}
	
	public String MedicName(int id) {
	for (Medic medic : listMedics) {
			if(medic.getMedicid()==id)return medic.getMedicname();
		}
		return "-1";
	}
	public static void main(String[] args) {
		MedicDAO medao = new MedicDAO();
		// Medic medic = new Medic();
		// medic.setMedicid(5);
		// medic.setMedicname("Thuốc tây");
		// medic.setDecription("không có chi");
		// medic.setQuantity("10");
		// medic.setTypeofmedicid("GD");
		// int kq= medao.updateMedic(medic);
		// System.out.println(kq);

		List<Medic> lisme = medao.getAllMedic();
		for (Medic medic :  medao.getAllMedic()) {
			System.out.println(medao.MedicName(medic.getMedicid()));
		}

	}
}
