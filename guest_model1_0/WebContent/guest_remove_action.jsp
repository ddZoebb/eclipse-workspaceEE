<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("guest_list.jsp");
	return;
}

request.setCharacterEncoding("UTF-8");
String guest_no=request.getParameter("guest_no");

GuestService guestService=new GuestService();
guestService.deleteGuest(Integer.parseInt(guest_no));

response.sendRedirect("guest_list.jsp");

%>