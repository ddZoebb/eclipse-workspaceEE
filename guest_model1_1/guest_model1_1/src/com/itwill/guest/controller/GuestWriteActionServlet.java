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
@WebServlet("/guest_write_action.do")
public class GuestWriteActionServlet extends HttpServlet {
      
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		try {
		if(request.getMethod().equalsIgnoreCase("GET")){
			/*
			 * response.sendRedirect("guest_list.do"); return;
			 */
			forwardPath="redirect:guest_main.do";
		}else {
		
	

		Guest guest=new Guest(0,request.getParameter("guest_name"),null,request.getParameter("guest_email"),
				request.getParameter("guest_homepage"),request.getParameter("guest_title"),request.getParameter("guest_content"));
		GuestService guestService=new GuestService();

		guestService.insertGuest(guest);
		forwardPath="redirect:guest_list.do";
		
		/* forwardPath="forward:/WEB-INF/views/guest_write_action.jsp"; */
		
		}
		}catch(Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
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
		/***************서블릿 공통부분*************/	
	}

}
