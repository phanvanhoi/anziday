package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.Account;
import com.bean.AcountUserTypeOfPeople;
import com.bean.User;

import connection.DataAccess;

public class UserDAO {
	
	DataAccess instanceSQL = DataAccess.getInstance();
	
//	List<TreatmentArea> treatmentAreas;
//	public UserDAO() {
//		treatmentAreas = new ArrayList<TreatmentArea>();
//				// TODO Auto-generated constructor stub
//	}
	
	public boolean insertUser(User user){
		boolean flag=false;
		Connection con = null;
		PreparedStatement preStm = null;
		int kq[]=null;
		con = instanceSQL.createConnection();
		String sql = "insert into Users values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con.setAutoCommit(false);
			preStm=con.prepareStatement(sql);
			preStm.setString(1, user.getUserid());
			preStm.setString(2, user.getFullname());
			preStm.setNString(3, user.getGender());
			preStm.setString(4, user.getBirthday());
			preStm.setString(5, user.getPosition());
			preStm.setString(6, user.getAdress());
			preStm.setString(7, user.getCmnd());
			preStm.setString(8, user.getMail());
			preStm.setString(9, user.getEducationlevel());
			preStm.setString(10, user.getCoefficientsalary());
			preStm.setString(11, user.getPhonenumber());
			preStm.setString(12, user.getImage());
			flag = preStm.executeUpdate()==1?true:false;
			con.commit();
		}
		catch (SQLException e) {
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
	public boolean insertAccount(Account account){
		boolean flag=false;
		Connection con = null;
		PreparedStatement preStm = null;
		PreparedStatement preStmac = null;
		int kq[]=null;
		con = instanceSQL.createConnection();
		String sql = "insert into Account values(?,?,?,?,?)";
		try {
			con.setAutoCommit(false);
			preStm=con.prepareStatement(sql);
			preStm.setString(1, account.getUserid());
			preStm.setString(2, account.getUsername());
			preStm.setString(3, account.getPassword());
			preStm.setString(4, account.getTypeid());
			preStm.setString(5, "Mo");
			flag = preStm.executeUpdate()==1?true:false;
			con.commit();
		}
		catch (SQLException e) {
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
	public List<User> listUser(){
		List<User>  mapUser = new ArrayList<>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con.prepareStatement("select FullName,Account.UserID,Birthday,Position,Gender,UAddress,CMND,Mail,PhoneNumber,EducationLevel,UserName,CoefficientSalary,TypeOfPeople.TypeID"
										+ " From Account join Users on Account.UserID = Users.UserID "
										+ "	join TypeOfPeople on Account.TypeID = TypeOfPeople.TypeID");
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFullname(rs.getString(1));
				user.setUserid(rs.getString(2));
				user.setBirthday(rs.getString(3));
				user.setPosition(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setAdress(rs.getString(6));
				user.setCmnd(rs.getString(7));
				user.setMail(rs.getString(8));
				user.setPhonenumber(rs.getString(9));
				user.setEducationlevel(rs.getString(10));
				user.setUsername(rs.getString(11));
				user.setCoefficientsalary(rs.getString(12));
				user.setTypeid(rs.getString(13));
				mapUser.add(user);
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
		return mapUser;
	}
	public boolean updateUser(User user) {
		boolean flag = false;
		int kq=0;
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		String sql ="select * From Users";
		try {
			preStm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(user.getUserid())) {
					rs.updateString("FullName",  user.getFullname());
					rs.updateString("Gender", user.getGender());
					rs.updateString("Birthday", user.getBirthday());
					rs.updateString("UAddress", user.getAdress());
					rs.updateString("CMND", user.getCmnd());
					rs.updateString("Mail", user.getMail());
					rs.updateString("Position", user.getPosition());
					rs.updateString("PhoneNumber", user.getPhonenumber());
					rs.updateString("EducationLevel", user.getEducationlevel());
					rs.updateString("CoefficientSalary", user.getCoefficientsalary());
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
	public boolean updateAccount(Account account) {
		boolean flag = false;
		int kq=0;
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		String sql = "Select * from Account";
		try {
			preStm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(account.getUserid())) {
					rs.updateString("UserName",  account.getUsername());
					rs.updateString("TypeID", account.getTypeid());
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
	public List<Account> listAccount(){
		List<Account> listacc = new ArrayList<>();
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con.prepareStatement("select * From Account");
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setUserid(rs.getString(1));
				account.setUsername(rs.getString(2));
				account.setPassword(rs.getString(3));
				account.setTypeid(rs.getString(4));
				listacc.add(account);
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
		return listacc;
	}
	public boolean deleteRoom(String id) {
		Connection con = null;
		int kq=0;
		boolean flag = false;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			con.setAutoCommit(false);
			preStm = con.prepareStatement("delete from Users where UserID=?");
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
	
	public boolean duplicateId(String id) {
		boolean flag =false;
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();
		try {
			preStm = con.prepareStatement("select UserID From Account");
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equals(id))flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
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

	public List<AcountUserTypeOfPeople> getUsers() {
		ResultSet rs = null;
		Connection con = instanceSQL.createConnection();
		String query = "SELECT Users.UserID as UsersID, UserName, Password, FullName, Gender, Birthday, Position, UAddress, CMND, Mail, EducationLevel, CoefficientSalary, PhoneNumber, Account.TypeID as TypeID, TypeName FROM Account\r\n"
				+ "INNER JOIN Users ON Account.UserID = Users.UserID\r\n"
				+ "INNER JOIN TypeOfPeople ON Account.TypeID = TypeOfPeople.TypeID";
		Statement statement;

		try {
			statement = con.createStatement();
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<AcountUserTypeOfPeople> list = new ArrayList<>();
		AcountUserTypeOfPeople user = null;

		try {
			while (rs.next()) {
				user = new AcountUserTypeOfPeople();
				user.setUserid(rs.getString("UsersID"));
				user.setUsername(rs.getString("UserName"));
				user.setFullname(rs.getString("FullName"));
				user.setGender(rs.getInt("Gender"));
				user.setBirthday(rs.getString("Birthday"));
				user.setPosition(rs.getString("Position"));
				user.setAdress(rs.getString("UAddress"));
				user.setCmnd(rs.getString("CMND"));
				user.setMail(rs.getString("Mail"));
				user.setEducationlevel(rs.getString("EducationLevel"));
				user.setCoefficientsalary(rs.getString("CoefficientSalary"));
				user.setPhonenumber(rs.getString("PhoneNumber"));
				user.setTypename(rs.getString("TypeName"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<User> ListNamePeople(int type) throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		Connection con = instanceSQL.createConnection();
		Statement preStm = con.createStatement();
		String sql ="select * from Users a inner join Account b on a.UserID =b.UserID where b.TypeID =" + type;
		System.out.println(sql);
		ResultSet rs =preStm.executeQuery(sql);
		User user;
		while (rs.next()){
			user = new User(rs.getString("UserID"), rs.getString("FullName"), 
					rs.getString("Gender"), rs.getString("Birthday"), 
					rs.getString("Position"), rs.getString("UAddress"), 
					rs.getString("CMND"), rs.getString("Mail"), 
					rs.getString("EducationLevel"), rs.getString("CoefficientSalary"),
					rs.getString("PhoneNumber"));
			list.add(user);
		}
		return list;
	}

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		dao.getUsers();
	}
}
