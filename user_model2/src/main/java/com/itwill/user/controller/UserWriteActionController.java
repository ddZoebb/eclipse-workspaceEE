package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserWriteActionController implements Controller {
	private UserService userService;
	
	public UserWriteActionController() throws Exception {
		userService=new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
	if(request.getMethod().equalsIgnoreCase("GET")){
		forwardPath="redirect:user_main.do";
		return forwardPath;
	}
	
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	User newUser=new User(userId,password,name,email);
	int result=userService.create(newUser);
	if(result==-1){
		
		String msg=userId+ "는 이미존재하는 아이디입니다.";
		request.setAttribute("msg", msg);
		request.setAttribute("fuser", newUser);
		
		forwardPath="forward:/WEB-INF/views/user_write_form.jsp";
		
		
	}else if(result==1){
		/*##################회원가입성공#################*/
		forwardPath="redirect:user_login_form.do";
	}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
	
		return forwardPath;
		
	}

}
