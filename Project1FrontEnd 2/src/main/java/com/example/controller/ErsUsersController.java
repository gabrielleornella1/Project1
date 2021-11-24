package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ErsUsersDaoImp;
import com.example.model.ErsUsersModel;
import com.example.service.ErsUsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErsUsersController {
	
	//static ErsUsersService userServ = new ErsUsersService(new ErsUsersDaoImp());

	
	
	
	public static String login(HttpServletRequest req) {
		System.out.println("in ersUsers controller login");
		if(!req.getMethod().equals("POST")) {//prevent login if they are not using an HTTP POST.
			return "html/unsuccessfulllogin.html";
			
		}
		
		//next we will process out the information that is sent in the request.
		System.out.println("Verifying user in Controller");
		ErsUsersService userServ = new ErsUsersService(new ErsUsersDaoImp());
		ErsUsersModel user = userServ.getErsUsersVerify(req.getParameter("ers_username"), req.getParameter("ers_password"));
		
		if(user == null) {
			System.out.println("Wrong Credentials");
			return "Wrongcreds.change";
			
		}else if(user.getUser_role_id()==2) {
			req.getSession().setAttribute("currentUser", user);
			return "html/ersusers.html";
		}else if(user.getUser_role_id()==1) {
			req.getSession().setAttribute("currentUser", user);
			ErsReimbController managerView = new ErsReimbController();
			managerView.financialMangerView(req);

			return "html/financialmanager.html";
			
		}else {
			return "wrongcreds.change";
		}
		
		
	}
	
	
	
	
	public static String signUp(HttpServletRequest req) {
		System.out.println("in ersUsers controller signup");
		if(!req.getMethod().equals("POST")) {
			return "html/unsuccessfulllogin.html";
		}
		
		
		System.out.println("Verify signup in controller");
		ErsUsersService userServ = new ErsUsersService(new ErsUsersDaoImp());
		boolean result = userServ.getErsUsersSignUp(Integer.parseInt(req.getParameter("user_id")), req.getParameter("username"),req.getParameter("password")
				,req.getParameter("first_name"),req.getParameter("last_name"),req.getParameter("email"),Integer.parseInt(req.getParameter("user_role_id")));//where i left
		
		if(result)
		{
			return "html/SuccessfulSignup.html";
		}
		else
		{
			return null;
		}
	
	}
	
	
	
	
	
	
	//sending JSON respond to the front end
	public static void getSessionErsUsers(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		
		ErsUsersModel user = (ErsUsersModel)req.getSession().getAttribute("currentUser");//we are grabbing the currentUser that is
		//stored in the session during the login
		//Then we will use the response object to send the current logged users as a JSON to the front end
		res.getWriter().write(new ObjectMapper().writeValueAsString(user));
	}

	

}
