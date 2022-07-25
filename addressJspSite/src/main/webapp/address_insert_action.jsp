<%@page import="com.itwill.address.AddressService"%>
<%@page import="com.itwill.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
 * 0.요청객체encoding설정
 * 1.파라메타받기(id,name,phone,address)--> Address객체생성
 * 2.AddressService객체생성
 * 3.AddressService.insert(Address객체)메쏘드실행
 * 4.address_list.jsp 로 redirection
 */
 
 if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("address_list.jsp");
		return;
	}
 
 request.setCharacterEncoding("UTF-8");
 String id=request.getParameter("id");
 String name=request.getParameter("name");
 String phone=request.getParameter("phone");
 String address=request.getParameter("address");
 
 Address insertAddress=new Address(0,id,name,phone,address);
 
 AddressService addressService=new AddressService();
 
 addressService.insert(insertAddress);
 
 response.sendRedirect("address_list.jsp");

%>

