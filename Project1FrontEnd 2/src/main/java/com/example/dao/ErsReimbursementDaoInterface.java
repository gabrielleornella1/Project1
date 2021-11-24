package com.example.dao;

import java.util.List;

import com.example.model.ErsReimbursementModel;
import com.example.model.ErsUsersModel;

public interface ErsReimbursementDaoInterface extends GenericDao<ErsReimbursementModel> {
	
	List<ErsReimbursementModel> findByReimbId(int reimb_id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//List<ErsUsersModel> findById(int ers_users_id);
//	
//	ErsUsersModel getByUserName(String ers_username);
//
//	 ErsUsersModel getByUserNameAndType(String ers_username, int user_role_id);
//	 


}
