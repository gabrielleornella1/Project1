package com.example.dao;

import java.util.List;

import com.example.model.ErsUsersModel;


public interface ErsUsersDaoInterface extends GenericDao<ErsUsersModel>{
	
	List<ErsUsersModel> findById(int ers_users_id);
	
	ErsUsersModel getByUserName(String ers_username);

	 ErsUsersModel getByUserNameAndType(String ers_username, int user_role_id);
	 

}
