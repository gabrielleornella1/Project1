package com.example.service;

import com.example.dao.ErsUsersDaoImp;
import com.example.model.ErsUsersModel;

public class ErsUsersService {
	
	private ErsUsersDaoImp sDao;
	
	
	public ErsUsersService() {
		// TODO Auto-generated constructor stub
	}
	

	public ErsUsersService(ErsUsersDaoImp sDao) {
		super();
		this.sDao = sDao;
	}
	
	
	public ErsUsersModel getErsUsersVerify(String ers_username, String ers_password) {
		
		System.out.println("username = "+ ers_username + " password="+ ers_password);
		
		ErsUsersModel users = sDao.getByUserName(ers_username);
		
		//System.out.println("Email=" + users.getUser_email());
		if(users != null) {
			if(users.getErs_password().equals(ers_password)) {
				return users;
			}
		}
		
		return null;
		
	}


	public boolean getErsUsersSignUp(int user_id, String ers_username,
			String ers_password, 
			String user_first_name, 
			String user_last_name, 
			String user_email, 
			int user_role_id ){
		
		System.out.println("In Service Signup");
		ErsUsersModel newErsUsers = new ErsUsersModel();
		newErsUsers.setErs_users_id(user_id);
		newErsUsers.setErs_username(ers_username);
		newErsUsers.setErs_password(ers_password);
		newErsUsers.setUser_first_name(user_first_name);
		newErsUsers.setUser_last_name(user_last_name);
		newErsUsers.setUser_email(user_email);
		newErsUsers.setUser_role_id(user_role_id);
		
		if(sDao.insert(newErsUsers )==true)
		{
			return true;
		}
		else 
		{
			return false;
		}
		

	}
	
	
	

}
