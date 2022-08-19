<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="itwill" uri="http://www.itwill.co.kr/jsp/simpleTag" %>
<%
session.setAttribute("sUserId", "zoe");
request.setAttribute("name", "현빈");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>custom tag[사용자정의태그]</h1><hr>
----------------hello tag----------<br>
<itwill:hello/>
<itwill:hello/>
<itwill:hello/>

----------------helloAttr tag---------------<br>
<itwill:helloAttr name="차은우"/>
<itwill:helloAttr name="공유"/>
<itwill:helloAttr name="${name}"/>

<itwill:helloAttr name=""></itwill:helloAttr>

-----------------if tag[body]--------<br>
<itwill:if test="true">
반드시실행 <br>
</itwill:if>
<itwill:if test="false">반드시실행 x <br></itwill:if>
<itwill:if test="${sUserId != null }">
${sUserId } 님 안녕하세요! <br>
</itwill:if>
<itwill:if test="${sUserId == null }">
GUEST 님 안녕하세요! <br>
</itwill:if>
<itwill:if test="${sUserId != null }">
${name } 님 안녕하세요! <br>
</itwill:if>
<itwill:if test="${empty sUserId }">
<a href='user_login_form.jsp'>로그인</a>
</itwill:if>
<itwill:if test="${!empty sUserId }">
<a href='user_logout_action.jsp'>로그아웃</a>
</itwill:if>
</body>
</html>