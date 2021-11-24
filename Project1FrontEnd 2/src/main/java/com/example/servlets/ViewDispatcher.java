package com.example.servlets;

import javax.servlet.http.HttpServletRequest;

import com.example.controller.ErsReimbController;
import com.example.controller.ErsUsersController;

public class ViewDispatcher {//this view dispatcher is going to be called by the view Servlet, it will filter the URI
	//of the request passed to it to determine which controller it should call, and return a string that will change the view of the user
	
	
	public static String process(HttpServletRequest req) {
		
		switch(req.getRequestURI()) 
		{
		
		
		case "/Project1FrontEnd/login.change":
			System.out.println("in login.change dispatcher");
			return ErsUsersController.login(req);
		
		case "/Project1FrontEnd/signup.change":
			System.out.println("in signup.change dispatcher");
			return ErsUsersController.signUp(req);
			
		case "/Project1FrontEnd/reimbsubmmit.change":
			System.out.println("in reimbsubmmit.change dispatcher");
			return ErsReimbController.ErsReimbSubmit(req);
		
		case "/Project1FrontEnd/approve.change":
			System.out.println("in approval.change dispatcher");
			return ErsReimbController.approve(req);
			
			
		default:
				System.out.println("in default");
				return "html/unsuccessfulllogin.html";
		
		
		}
	}

}
