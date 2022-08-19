package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.UserService;

public class UserRemoveActionController implements Controller {
	private UserService userService;
	
	public UserRemoveActionController() throws Exception{
		userService=new UserService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:user_main.do";
				return forwardPath;
			}
			userService.remove(sUserId);
	
			request.getSession().invalidate();
			forwardPath="redirect:user_main.do";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
	}

}
