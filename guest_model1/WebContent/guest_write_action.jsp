<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("guest_list.jsp");
	return;
}
request.setCharacterEncoding("UTF-8");
String guest_name=request.getParameter("guest_name");
String guest_email=request.getParameter("guest_email");
String guest_homepage=request.getParameter("guest_homepage");
String guest_title=request.getParameter("guest_title");
String guest_content=request.getParameter("guest_content");

Guest guest=new Guest(0,guest_name,null,guest_email,guest_homepage,guest_title,guest_content);
GuestService guestService=new GuestService();

guestService.insertGuest(guest);

response.sendRedirect("guest_list.jsp");
%>