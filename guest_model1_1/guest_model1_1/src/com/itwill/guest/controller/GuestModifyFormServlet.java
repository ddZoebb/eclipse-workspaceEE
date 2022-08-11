package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_modify_form.do")
public class GuestModifyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = "";
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				/*
				 * response.sendRedirect("guest_list.do"); return;
				 */
				forwardPath="redirect:guest_main.do";
			}else {

			request.setCharacterEncoding("UTF-8");
			GuestService guestService = new GuestService();
			Guest guest = guestService.selectByNo(Integer.parseInt(request.getParameter("guest_no")));
			request.setAttribute("guest", guest);
			forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";

		}

		/******************************* forward, redirect ******/
		/*
		 * forward --> forward: /WEB-INF/views/guest_xxx.jsp redirect --> redirect:
		 * guest_xxx.do
		 */
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path = pathArray[1];
		if (forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		} else if (forwardOrRedirect.equals("forward")) {

			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		/*************** 서블릿 공통부분 *************/

	}

}
