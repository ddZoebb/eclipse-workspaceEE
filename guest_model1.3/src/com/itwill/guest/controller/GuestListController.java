package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestListController implements Controller{
	private GuestService guestService;
	
	public GuestListController() {
		guestService=new GuestService();
	}
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			
		
			 List<Guest> guestList=guestService.selectAll();
			 request.setAttribute("guestList", guestList);
			 forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}

		return forwardPath;
				
	}

}
