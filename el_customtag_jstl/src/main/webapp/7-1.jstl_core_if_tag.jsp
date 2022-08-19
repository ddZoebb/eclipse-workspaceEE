<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
session.setAttribute("sUserId", "guard");
request.setAttribute("level", 5);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL core if tag</h1>
	<hr>
	<c:if test="true">
1. 반드시 실행 <br>
</c:if>
	<c:if test="${empty sUserId }">
		<a href='login_form.jsp'>로그인</a>
	</c:if>
	<c:if test="${!empty sUserId}">
		<a href='logout_action.jsp'>${sUserId }님 로그아웃</a><br>
	</c:if>
	
	
	<c:if test="${level!=null }">
	<c:if test="${level>=4 && level<=5 }">
	${level}입니다!<br>
	</c:if>
	</c:if>
	
	<c:if test="${level!=null&&(level>=4 && level<=5 )}">
	${level}입니다!<br>
	</c:if>
</body>
</html>
















