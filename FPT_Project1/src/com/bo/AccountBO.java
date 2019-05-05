package com.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Account;
import com.bean.AcountUserTypeOfPeople;
import com.dao.AccountDAO;

public class AccountBO {
	AccountDAO accountDAO = new AccountDAO();

	public boolean checkAccount(String username, String password) {
		try {
			if (accountDAO.checkAccount(username, password)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public AcountUserTypeOfPeople getInfoUser(String username, String password) {
		return accountDAO.getInfoUser(username, password);
	}

	public boolean changePassword(String userid, String password) {
		try {
			if (accountDAO.changePassword(userid, password)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean changeUserInfo(String userid, String fullname, int gender, String birthday, String address,
			String cmnd, String mail, String phonenumber, String education) {
		try {
			if (accountDAO.changeUserInfo(userid, fullname, gender, birthday, address, cmnd, mail, phonenumber,
					education)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public ArrayList<Account> listAccount(){
		ArrayList<Account> list = new ArrayList<>();
		try {
			list = accountDAO.listAccount();
		} catch (SQLException e) {
			System.out.println("loi truy van");
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Account> TypeOfPeople(int type){
		ArrayList<Account> list = new ArrayList<>();
		try {
			list = accountDAO.TypeOfPeople(type);
		} catch (SQLException e) {
			System.out.println("loi truy van");
			e.printStackTrace();
		}
		return list;
	}
	public void updateAccountMembers(Account account){
		try {
			accountDAO.updateAccountMembers(account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void blockAccountMembers(String account){
		try {
			accountDAO.blockAccountMembers(account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeFileJson(){
		accountDAO.writeFileJson();
	}
	public static void main(String[] args) {
		AccountBO accountBO = new AccountBO();
		System.out.println(accountBO.getInfoUser("nghia123", "123").getFullname());
	}

}
