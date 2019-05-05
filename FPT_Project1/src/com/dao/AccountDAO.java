package com.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Account;
import com.bean.AcountUserTypeOfPeople;
import com.bean.User;
import com.common.PasswordEncryption;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

import connection.DataAccess;

public class AccountDAO {
	DataAccess instanceSQL = DataAccess.getInstance();

	public ArrayList<Account> listAccount() throws SQLException {
		ArrayList<Account> list = new ArrayList<>();
		Connection con = instanceSQL.createConnection();
		Statement preStm = con.createStatement();
		String sql = "Select UserID, UserName, PassWord, TypeID, Status FROM Account";
		ResultSet result = preStm.executeQuery(sql);

		while (result.next()) {

			String userID = result.getString("UserID");
			String userName = result.getString("UserName");
			String passWord = result.getString("PassWord");
			String typeID = result.getString("TypeID");
			String status = result.getString("Status");
			list.add(new Account(userID, userName, passWord, typeID, status));
		}
		return list;

	}

	public ArrayList<Account> TypeOfPeople(int type) throws SQLException {
		ArrayList<Account> list = new ArrayList<>();
		Connection con = instanceSQL.createConnection();
		Statement preStm = con.createStatement();
		String sql = "Select UserID, UserName, PassWord, TypeID FROM Account where TypeID = " + type;
		ResultSet result = preStm.executeQuery(sql);

		while (result.next()) {

			String userID = result.getString("UserID");
			String userName = result.getString("UserName");
			String passWord = result.getString("PassWord");
			String typeID = result.getString("TypeID");
			String status = result.getString("Status");
			list.add(new Account(userID, userName, passWord, typeID, status));
		}
		return list;

	}

	
	public boolean checkAccount(String username, String password) throws SQLException {
		ResultSet rs = null;
		Connection con = instanceSQL.createConnection();
		Statement statement;
		;
		String query = "SELECT * FROM Account WHERE UserName = '" + username + "' AND Password = '" + password + "'";
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
	}

	public AcountUserTypeOfPeople getInfoUser(String username, String password) {
		ResultSet rs = null;
		Connection con = instanceSQL.createConnection();
		Statement statement;
		String query = "SELECT Users.UserID as UsersID, UserName, Password, FullName, Gender, Birthday, Position, UAddress, CMND, Mail, EducationLevel, CoefficientSalary, PhoneNumber, Account.TypeID as TypeID, TypeName FROM Account\r\n"
				+ "INNER JOIN Users ON Account.UserID = Users.UserID\r\n"
				+ "INNER JOIN TypeOfPeople ON Account.TypeID = TypeOfPeople.TypeID\r\n" + "WHERE UserName = '"
				+ username + "' AND Password = '" + password + "'";

		try {
			statement = con.createStatement();
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		AcountUserTypeOfPeople acountUserTypeOfPeople = new AcountUserTypeOfPeople();
		try {
			while (rs.next()) {
				acountUserTypeOfPeople.setUserid(rs.getString("UsersID"));
				acountUserTypeOfPeople.setUsername(rs.getString("UserName"));
				acountUserTypeOfPeople.setPassword(rs.getString("Password"));
				acountUserTypeOfPeople.setTypeid(rs.getString("TypeID"));
				acountUserTypeOfPeople.setFullname(rs.getString("FullName"));
				acountUserTypeOfPeople.setGender(Integer.parseInt(rs.getString("Gender")));
				acountUserTypeOfPeople.setBirthday(rs.getString("Birthday"));
				acountUserTypeOfPeople.setPosition(rs.getString("Position"));
				acountUserTypeOfPeople.setAdress(rs.getString("UAddress"));
				acountUserTypeOfPeople.setCmnd(rs.getString("CMND"));
				acountUserTypeOfPeople.setMail(rs.getString("Mail"));
				acountUserTypeOfPeople.setEducationlevel(rs.getString("EducationLevel"));
				acountUserTypeOfPeople.setCoefficientsalary(rs.getString("CoefficientSalary"));
				acountUserTypeOfPeople.setPhonenumber(rs.getString("PhoneNumber"));
				acountUserTypeOfPeople.setTypename(rs.getString("TypeName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acountUserTypeOfPeople;
	}

	public boolean changePassword(String userid, String password) throws SQLException {
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();

		String query = "UPDATE Account SET Password = ? WHERE UserID = ?";
		try {
			preStm = con.prepareStatement(query);
			preStm.setString(1, password);
			preStm.setString(2, userid);
			if (preStm.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preStm != null) {
				preStm.close();
			}
		}
	}

	public boolean changeUserInfo(String userid, String fullname, int gender, String birthday, String address,
			String cmnd, String mail, String phonenumber, String education) throws SQLException {
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();

		String query = "UPDATE Users SET FullName = ?, Gender = ?, Birthday = ?, UAddress = ?, CMND = ?, Mail = ?, EducationLevel = ?, PhoneNumber = ? WHERE UserID = ?";
		try {
			preStm = con.prepareStatement(query);
			preStm.setString(1, fullname);
			preStm.setInt(2, gender);
			preStm.setString(3, birthday);
			preStm.setString(4, address);
			preStm.setString(5, cmnd);
			preStm.setString(6, mail);
			preStm.setString(7, education);
			preStm.setString(8, phonenumber);
			preStm.setString(9, userid);
			if (preStm.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preStm != null) {
				preStm.close();
			}
		}
	}
	
	
	public void updateAccountMembers(Account account) throws SQLException {
		Connection con = instanceSQL.createConnection();
		String sql = "Update Account set Password = ?, TypeID = ?, Status =N'" + account.getStatus()
				+ "' where UserID = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, account.getPassword());
		pstm.setString(2, account.getTypeid());
		pstm.setString(3, account.getUserid());
		pstm.executeUpdate();
		System.out.println("update thành công :p");
	}

	public void blockAccountMembers(String userid) throws SQLException {
		System.out.println("userid: " + userid);
		Connection con = instanceSQL.createConnection();
		String sql = "Update Account set Status = N'Blocked' where UserID = ?";

		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, userid);

		System.out.println(pstm.executeUpdate());
		System.out.println("block thành công :p");
		System.out.println(sql);
	}

	public void writeFileJson() {
		AccountDAO acDAO = new AccountDAO();
		try {

			JsonFactory jfactory = new JsonFactory();

			/*** write to file ***/
			JsonGenerator jGenerator = jfactory.createJsonGenerator(new File("C:\\Users\\trann\\Downloads\\FPT_Project1\\WebContent\\public\\account.json"), JsonEncoding.UTF8);
			jGenerator.writeStartObject();  // {
			jGenerator.writeFieldName("listAccount");
			jGenerator.writeStartArray(); // [
			
			ArrayList<Account> listAc = new ArrayList<>();
			try {
				listAc = acDAO.listAccount();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // UserID, UserName, PassWord, TypeID
			for (Account ac : listAc) {
				jGenerator.writeStartObject(); // {
				jGenerator.writeStringField("userid", ac.getUserid());
				jGenerator.writeStringField("username", ac.getUsername());
				jGenerator.writeStringField("password", ac.getPassword());
				jGenerator.writeStringField("typeid", ac.getTypeid());
				jGenerator.writeStringField("status", ac.getStatus());
				jGenerator.writeEndObject(); // }
			}
		
			/*
			 * jGenerator.writeStringField("name", "mkyong"); // "name" :
			 * "mkyong" jGenerator.writeNumberField("age", 29); // "age" : 29
			 * 
			 * jGenerator.writeFieldName("messages"); // "messages" :
			 * jGenerator.writeStartArray(); // [
			 * 
			 * jGenerator.writeString("msg 1"); // "msg 1"
			 * jGenerator.writeString("msg 2"); // "msg 2"
			 * jGenerator.writeString("msg 3"); // "msg 3"
			 * 
			 * jGenerator.writeEndArray(); // ]
			 */
			
			jGenerator.writeEndArray(); // ]
			jGenerator.writeEndObject(); // }
			jGenerator.close();

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void readFileJson() {
		try {

			JsonFactory jfactory = new JsonFactory();
			/*** read from file ***/
			JsonParser jParser = jfactory.createJsonParser(new File("C:\\Users\\trann\\Downloads\\FPT_Project1\\WebContent\\public\\account.json"));
			// loop until token equal to "}"
			while (jParser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = jParser.getCurrentName();
				if ("userid".equals(fieldname)) {
					// current token is "name",
					// move to next, which is "name"'s value
					jParser.nextToken();
					System.out.println(jParser.getText()); // display mkyong
				}
				if ("username".equals(fieldname)) {
					// current token is "age",
					// move to next, which is "name"'s value
					jParser.nextToken();
					System.out.println(jParser.getText());
					//System.out.println(jParser.getIntValue()); // display 29
				}
				if ("password".equals(fieldname)) {
					// current token is "age",
					// move to next, which is "name"'s value
					jParser.nextToken();
					System.out.println(jParser.getText());
					//System.out.println(jParser.getIntValue()); // display 29
				}
				if ("typeid".equals(fieldname)) {
					// current token is "age",
					// move to next, which is "name"'s value
					jParser.nextToken();
					System.out.println(jParser.getText());
					//System.out.println(jParser.getIntValue()); // display 29
				}
				if ("status".equals(fieldname)) {
					// current token is "age",
					// move to next, which is "name"'s value
					jParser.nextToken();
					System.out.println(jParser.getText());
					//System.out.println(jParser.getIntValue()); // display 29
				}
				/*if ("password".equals(fieldname)) {
					jParser.nextToken(); // current token is "[", move next
					// messages is array, loop until token equal to "]"
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						// display msg1, msg2, msg3
						System.out.println(jParser.getText());
					}
				}*/
			}
			jParser.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public ArrayList<User> ListNamePeople(int type) throws SQLException {
	 * ArrayList<User> list = new ArrayList<>(); Connection con =
	 * instanceSQL.createConnection(); Statement preStm = con.createStatement();
	 * String sql
	 * ="select * from Users a inner join Account b on a.UserID =b.UserID where b.TypeID ="
	 * + type; ResultSet result =preStm.executeQuery(sql);
	 * 
	 * while (result.next()){ String fullName = result.getString("FullName");
	 * list.add(fullName); } return list;
	 * 
	 * }
	 */
	
	public static void main(String[] args) {
		AccountDAO a = new AccountDAO();
		a.writeFileJson();
		a.readFileJson();
		
		PasswordEncryption encryption = new PasswordEncryption();
		System.out.println(encryption.md5("Abcde12345"));
	}

	/*
	 * public void insertDichVu(DichVu dichVu) throws SQLException{
	 * MyConnectionDAO mycon = new MyConnectionDAO(); Connection kn =
	 * mycon.createConnection(); String sql =
	 * "Insert into DichVu(MaDichVu, TenDichVu, DonViTinh, DonGia)" +
	 * "values(?, ?, ?, ?)"; PreparedStatement pstm = kn.prepareStatement(sql);
	 * pstm.setString(1, dichVu.getMaDichVu()); pstm.setString(2,
	 * dichVu.getTenDichVu()); pstm.setString(3, dichVu.getDonViTinh());
	 * pstm.setFloat(4, dichVu.getDonGia()); pstm.executeUpdate(); con.close();
	 * preStm.close(); }
	 */

}
