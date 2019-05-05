package com.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Account;
import com.bean.AcountUserTypeOfPeople;
import com.bean.User;
import com.dao.UserDAO;

public class UserBO {
	private static UserBO instance;
	UserDAO userDAO = new UserDAO();
	public static UserBO getInstance(){
		if(instance == null){
			instance = new UserBO();
		}
		return instance;
	}
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.insertUser(user);
	}
	public boolean insertAccount(Account account) {
		// TODO Auto-generated method stub
		return userDAO.insertAccount(account);
	}
	public List<User> getAllUser(){
		return userDAO.listUser();
	}
	public List<Account> getAllAccount(){
		return userDAO.listAccount();
	}
	public boolean deleteUser(String id){
		return userDAO.deleteRoom(id);
	}
	public boolean updateUser(User user){
		return userDAO.updateUser(user);
	}
	public List<AcountUserTypeOfPeople> getUsers() {
		return userDAO.getUsers();
	}
	public boolean duplicateId(String id) {
		// TODO Auto-generated method stub
		return userDAO.duplicateId(id);
	}
	
	public boolean updateAccount(Account account){
		return userDAO.updateAccount(account);
	}
	public ArrayList<User> ListNamePeople(int type) throws SQLException
	{
		return userDAO.ListNamePeople(type);
	}
}
