package com.example.service;

import java.sql.Timestamp;
import java.util.List;

import com.example.dao.ErsReimbursementDaoImp;
import com.example.dao.ErsUsersDaoImp;
import com.example.model.ErsReimbursementModel;
import com.example.model.ErsUsersModel;

public class ErsReimbService {
	
	
	private ErsReimbursementDaoImp ersDao;
	
	public ErsReimbService() {
		// TODO Auto-generated constructor stub
	}
	

	public ErsReimbService(ErsReimbursementDaoImp ersDao) {
		super();
		this.ersDao = ersDao;
	}
	
	
	
	
	
	public boolean getErsReimbSubmmit(int reimb_id, Double reimb_amount,
			Timestamp reimb_submitted, 
			Timestamp reimb_resolved, 
			String reimb_description, 
			int reimb_author, 
			int reimb_resolver,
			int reimb_status_id,
			int reimb_type_id){
		
		System.out.println("In Service Signup");
		ErsReimbursementModel newErsReimb = new ErsReimbursementModel();
		newErsReimb.setReimb_id(reimb_id);
		newErsReimb.setReimb_amount(reimb_id);
		newErsReimb.setReimb_submitted(reimb_submitted);
		newErsReimb.setReimb_resolved(reimb_resolved);
		newErsReimb.setReimb_description(reimb_description);
		newErsReimb.setReimb_author(reimb_author);
		newErsReimb.setReimb_resolver(reimb_resolver);
		newErsReimb.setReimb_status_id(reimb_status_id);
		newErsReimb.setReimb_type_id(reimb_type_id);
		
		
		if(ersDao.insert(newErsReimb))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean getReimbApproved(int reimb_id) {
		System.out.println("Service Reimbursement Approve");
		ErsReimbursementModel newErsReimbUpdate= new ErsReimbursementModel();
		newErsReimbUpdate.setReimb_id(reimb_id);
		return ersDao.updateApprove(newErsReimbUpdate);
		
	}
	
}

	
	
	
	
	
	
	
	
//	public ErsReimbursementModel getErsReimbVerify(int reimb_id ) {//where I left
//			
//			System.out.println("reimb= "+ reimb_id);
//			
//			List<ErsReimbursementModel> ErsReimb = sDao.findByReimbId(reimb_id);
//			
////			if(ErsReimb != null) {
////				if(users.getErs_password().equals(ers_password)) {
//					return users;
//				}
//			}
			
			//return null; coming back to this
			
		
	
