<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("sUserId", "guard2");
request.setAttribute("sUserId", "guard3");
session.setAttribute("sUserId", "guard1");
application.setAttribute("sUserId", "guard4");


request.setAttribute("name", "제임스딘");

double height=168.8;
String address="서울";
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL String,Wrapper객체(기본형객체) 출력</h1>
<ol>
<li>${sUserId }</li>
<li>${name }</li>
<li>EL출력불가능
<li>${height }</li>
<li>${address }</li>
	
	
</ol>
</body>
</html>