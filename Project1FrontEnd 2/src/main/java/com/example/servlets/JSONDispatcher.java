package com.example.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.ErsReimbController;
import com.example.controller.ErsUsersController;
import com.example.model.ErsReimbursementModel;
import com.example.model.ErsUsersModel;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONDispatcher {
	
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		switch(req.getRequestURI()) {
		case "/Project1FrontEnd/getsessionusers.json":
			System.out.println("in get session ersusers case, dispatcher");
			
			ErsUsersController.getSessionErsUsers(req, res);
			
			break;
		case "/Project1FrontEnd/getSessionErsReimb.json":
			ErsReimbController.getSessionErsReimb(req, res);
			break;
			
			
		case "/Project1FrontEnd/approveErsReimb.json":
			ErsReimbController.approve(req);
			break;
			
		default:
			System.out.println("in JSON default");
			res.getWriter().write(new ObjectMapper().writeValueAsString(new ErsReimbursementModel()));
		}
		
	}

}
