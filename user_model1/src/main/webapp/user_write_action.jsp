<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}

	//request.setCharacterEncoding("UTF-8");
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	
	UserService userService=new UserService();
	User user=new User(userId,password,name,email);
	
	int check=userService.create(user);
	if(check==-1){
		/*##################아이디중복#################*/
		response.sendRedirect("user_write_form.jsp");
		out.println("<script>");
		out.println("alert('"+userId+"는 이미 존재하는 아이디입니다.');" );
		out.println("location.href='user_write_form.jsp';");
		out.println("</script>");
	}else if(check==1){
		/*##################회원가입성공#################*/
		response.sendRedirect("user_login_form.jsp");
		
	}

%>
		














