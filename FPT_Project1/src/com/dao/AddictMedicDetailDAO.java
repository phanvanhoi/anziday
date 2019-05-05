package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Addict;
import com.bean.AddictMedicDetail;

import connection.DataAccess;

public class AddictMedicDetailDAO {
	DataAccess instanceSQL = DataAccess.getInstance();
	Connection sqlcon=null;
	PreparedStatement psttm=null;
	Statement sttm=null;
	ResultSet rs = null;
	public ArrayList<AddictMedicDetail> getListAddict(){
		ArrayList<AddictMedicDetail> arr = new ArrayList<AddictMedicDetail>();
		String sqlStr="select Addicts.AddictsID,AddictsName,Birthday,Gender,Addresses,RelativesName,Relationship,DocTor,Room,Prescrip.Statuss,Prescrip.PrescripID from Addicts left join Prescrip on Addicts.AddictsID =Prescrip.AddictsID";
		sqlcon = instanceSQL.createConnection();
		try {
			sttm=sqlcon.createStatement();
			rs=sttm.executeQuery(sqlStr);
			AddictMedicDetail detail ;
			while(rs.next()){
				detail = new AddictMedicDetail(rs.getString("AddictsID"), rs.getString("AddictsName"),
						rs.getString("Birthday"), rs.getString("Gender"), 
						rs.getString("Addresses"), rs.getString("RelativesName"), 
						rs.getString("Relationship"), rs.getString("DocTor"), 
						rs.getString("Room"), rs.getString("Statust"), 
						rs.getString("PrescripID"));
				arr.add(detail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	public ArrayList<AddictMedicDetail> getListAddict(int row,int total){
		ArrayList<AddictMedicDetail> arr = new ArrayList<AddictMedicDetail>();
		String sqlStr="SELECT * FROM(select Addicts.AddictsID,AddictsName,Birthday,Gender,Addresses,RelativesName,Relationship,DocTor,Room,Prescrip.Statuss,Prescrip.PrescripID,ROW_NUMBER() OVER (ORDER BY Addicts.AddictsID) RowNum from Addicts  left join AddictsMedic on Addicts.AddictsID =Prescrip.AddictsID) A WHERE RowNum BETWEEN "+((row-1)*total+1)+" AND "+total*row;
		sqlcon = instanceSQL.createConnection();
		System.out.println(sqlStr);
		try {
			sttm=sqlcon.createStatement();
			rs=sttm.executeQuery(sqlStr);
			AddictMedicDetail detail ;
			while(rs.next()){
				detail = new AddictMedicDetail(rs.getString("AddictsID"), rs.getString("AddictsName"),
						rs.getString("Birthday"), rs.getString("Gender"), 
						rs.getString("Addresses"), rs.getString("RelativesName"), 
						rs.getString("Relationship"), rs.getString("DocTor"), 
						rs.getString("Room"), rs.getString("Statuss"), 
						rs.getString("PrescripID"));
				arr.add(detail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	public ArrayList<AddictMedicDetail> getListAddict(int row,int total,String key,String where){
		ArrayList<AddictMedicDetail> arr = new ArrayList<AddictMedicDetail>();
		
		String sqlStr="SELECT * FROM(select Addicts.AddictsID,AddictsName,Birthday,Gender,Addresses,RelativesName,Relationship,DocTor,Room,Prescrip.Statust,Prescrip.PrescripID,ROW_NUMBER() OVER (ORDER BY Addicts.AddictsID) RowNum "
				+ "from Addicts  "
				+ "left join Prescrip on Addicts.AddictsID =Prescrip.AddictsID WHERE "+where+" Like N'%"+key+"%' " 
				+ ") A WHERE RowNum BETWEEN "+((row-1)*total+1)+" AND "+total*row;
		sqlcon = instanceSQL.createConnection();
		try {
			sttm=sqlcon.createStatement();
			rs=sttm.executeQuery(sqlStr);
			AddictMedicDetail detail ;
			while(rs.next()){
				detail = new AddictMedicDetail(rs.getString("AddictsID"), rs.getString("AddictsName"),
						rs.getString("Birthday"), rs.getString("Gender"), 
						rs.getString("Addresses"), rs.getString("RelativesName"), 
						rs.getString("Relationship"), rs.getString("DocTor"), 
						rs.getString("Room"), rs.getString("Statust"), 
						rs.getString("PrescripID"));
				arr.add(detail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	public ArrayList<AddictMedicDetail> getListAddict(String key,String where){
		ArrayList<AddictMedicDetail> arr = new ArrayList<AddictMedicDetail>();
		
		String sqlStr="SELECT * FROM(select Addicts.AddictsID,AddictsName,Birthday,Gender,Addresses,RelativesName,Relationship,DocTor,Room,Prescrip.Statust,Prescrip.PrescripID,ROW_NUMBER() OVER (ORDER BY Addicts.AddictsID) RowNum "
				+ "from Addicts  "
				+ "left join Prescrip on Addicts.AddictsID =Prescrip.AddictsID WHERE "+where+" Like N'%"+key+"%' " 
				+ ") A";
		sqlcon = instanceSQL.createConnection();
		System.out.println(sqlStr);
		try {
			sttm=sqlcon.createStatement();
			rs=sttm.executeQuery(sqlStr);
			AddictMedicDetail detail ;
			while(rs.next()){
				detail = new AddictMedicDetail(rs.getString("AddictsID"), rs.getString("AddictsName"),
						rs.getString("Birthday"), rs.getString("Gender"), 
						rs.getString("Addresses"), rs.getString("RelativesName"), 
						rs.getString("Relationship"), rs.getString("DocTor"), 
						rs.getString("Room"), rs.getString("Statust"), 
						rs.getString("PrescripID"));
				arr.add(detail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println("cái gì");
		System.out.println(new AddictMedicDetailDAO().getListAddict(1,5,"nữ","Gender"));
	}
}
