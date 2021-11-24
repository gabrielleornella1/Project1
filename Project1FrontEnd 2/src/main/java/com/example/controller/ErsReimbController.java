package com.example.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.Dbconnection;
import com.example.dao.ErsReimbursementDaoImp;
import com.example.model.ErsReimbursementModel;
import com.example.service.ErsReimbService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ErsReimbController {
	
	
	
	public static String ErsReimbSubmit(HttpServletRequest req) {
		System.out.println("in ersReimbController submit");
		if(!req.getMethod().equals("POST")) {//prevent if they are not using an HTTP POST.
			return "html/unsuccessfullremb.html";
			
		}
		
		//next we will process out the information that is sent in the request.
		System.out.println("Verifying remb in Controller");
		ErsReimbService ersReimbServ = new ErsReimbService(new ErsReimbursementDaoImp());
		
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());

		
		boolean ersReimb = ersReimbServ.getErsReimbSubmmit(Integer.parseInt(req.getParameter("reimb_id")),
				Double.parseDouble(req.getParameter("reimb_amount")), 
				ts,
				ts,
				req.getParameter("reimb_description"),
				Integer.parseInt(req.getParameter("reimb_author")),
				Integer.parseInt(req.getParameter("reimb_resolver")),
				Integer.parseInt(req.getParameter("reimb_status_id")),
				Integer.parseInt(req.getParameter("reimb_type_id"))
				
				);//stop here
		
		if(ersReimb) {
			System.out.println("Nothing submitted");
			return "html/successfullreimbsubmit.html";
			
		}else {
			
			return "html/submitform.html";
		}
		
		
	}
	public void financialMangerView(HttpServletRequest req) {
		Dbconnection rdb = new Dbconnection();
		ErsReimbursementDaoImp rDao = new ErsReimbursementDaoImp(rdb);
		List<ErsReimbursementModel>reimBursList = rDao.getAll();
		req.getSession().setAttribute("currentReimb",reimBursList);
	}
	
	

	
	public static String approve(HttpServletRequest req) {
		
		System.out.println(req.getParameter("id"));
		int id = Integer.parseInt(req.getParameter("name"));

		ErsReimbService ersReimbServ = new ErsReimbService(new ErsReimbursementDaoImp());
		
		System.out.println("Reimb approve controller");
		boolean approveReimb = ersReimbServ.getReimbApproved(id);
		
		if(approveReimb) {
			return "html/approve.html";
			
		}else {
			return null;
			
		}
		
				
				
	}
	
	
	
	
	
	
	
	
	
	//sending JSON respond to the front end
	public static void getSessionErsReimb(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		
		List<ErsReimbursementModel> ersreimb = (List<ErsReimbursementModel>)req.getSession().getAttribute("currentReimb");//we are grabbing the currentUser that is
		//stored in the session during the login
		//Then we will use the response object to send the current logged users as a JSON to the front end
		res.getWriter().write(new ObjectMapper().writeValueAsString(ersreimb));
	}
	public static boolean ersReimbUpdate(HttpServletRequest req) {
		Dbconnection rdb = new Dbconnection();
		ErsReimbursementDaoImp rDao = new ErsReimbursementDaoImp(rdb);
		ErsReimbursementModel reimbApproval = new ErsReimbursementModel();
		boolean updateStatus =rDao.update(reimbApproval);
		req.getSession().setAttribute("currentReimb", reimbApproval);
		//need help with this fuction i skip the service layer part for this function
		
		return updateStatus;
	}


}



				
				