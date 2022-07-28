
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	
	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공(세션)
	 */
	 
	 if(request.getMethod().equalsIgnoreCase("GET")){
		 response.sendRedirect("user_login_form.jsp");
		 return;
	 }
	
	//request.setCharacterEncoding("UTF-8");
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	
	UserService userService=new UserService();
	int result=userService.login(userId,password);
	
	if(result==0){
		//아이디 존재안함
		String msg1=userId+" 는 존재하지 않는 아이디입니다.";
		/****************case1 script*******************
		out.println("<script>");
		out.println("alert('"+msg1+"');");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		*/
		request.setAttribute("msg1", msg1);
		User fuser=new User(userId,password,"","");
		request.setAttribute("fuser", fuser);
		RequestDispatcher rd=request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		
	}else if(result==1){
		//패스워드 불일치
		String msg2="비밀번호가 일치하지 않습니다.";
		/********************case1 script************************
		out.println("<script>");
		out.println("alert('"+msg2+"');");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		*/
		request.setAttribute("msg2", msg2);
		User fuser=new User(userId,password,"","");
		request.setAttribute("fuser", fuser);
		RequestDispatcher rd=request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		
		
	}else if(result==2){
		//로그인 성공 
		session.setAttribute("sUserId", userId);
		response.sendRedirect("user_main.jsp");
	}
	 
	
	
%>