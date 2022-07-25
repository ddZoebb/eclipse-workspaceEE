<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/***********응답객체를 사용하여 클라이언트에 쿠키전송[삭제]**************/

/*
 1. Cookie얻기
*/

Cookie[] cookies = request.getCookies();

if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("searchKeyword")) {
	cookie.setMaxAge(0);
	cookie.setValue("");
	
	response.addCookie(cookie);
	break;
		}
	}
}

/*
2. searchKeyword쿠키찾아서 setMaxAge(0)로설정
*/

/*
3.응답객체에추가(클라이언트로전송)
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키삭제</h1>
	<hr>
	<div>니안에 쿠키없다.</div>
	<div>
		<a href='7-0.cookie_search.jsp'>다시검색[쿠키읽기]</a>
	</div>
</body>
</html>










