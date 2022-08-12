package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyActionController implements Controller {
	private UserService userService;
	public UserModifyActionController() throws Exception {
		userService=new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		/*************/
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		if (sUserId == null) {
			forwardPath = "redirect:user_main.do";
			return forwardPath;
		}
		/*************/
		
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:user_main.do";
				return forwardPath;
			}
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			userService.update(new User(sUserId,password,name,email));
			forwardPath="redirect:user_view.do";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
	}

}
