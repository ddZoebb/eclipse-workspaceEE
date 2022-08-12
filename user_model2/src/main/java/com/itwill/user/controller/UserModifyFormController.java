package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyFormController implements Controller {
	private UserService userService;

	public UserModifyFormController() throws Exception {
		userService = new UserService();
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
			User loginUser = userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			forwardPath="forward:/WEB-INF/views/user_modify_form.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
	}

}
