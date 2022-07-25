<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

int count=0;

Integer countInt=(Integer)session.getAttribute("count");
if(countInt==null){
	//count key 값의 속성 객체가 존재하지 않음
	count=0;
}else{
	//count key 값의 속성 객체가 존재함
	count=countInt.intValue();
}
count++;
/*
세션장바구니객체에 count라는 key로 Integer객체를 저장
세션장바구니 객체는 저장데이터를 hashMap으로 관리합니다 
*/
session.setAttribute("count", new Integer(count));
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HttpSession 객체 사용한 클라이언트별(브라우저별) 요청횟수 카운트</h1>
<h3><%=session.getId()  %>님 <%=count %>번째 요청입니다.</h3>
<br>
<br>
<br>
<ol>
<li>session 객체 참조변수 : <%=session %></li>
<li>session 객체 생성여부 : <%=session.isNew() %></li>
<li>session 객체 세션아이디 : <%=session.getId() %></li>
<li>session 객체 세션생성시간 : <%=session.getCreationTime() %></li>
<li>session 객체 객체유효시간 : <%=session.getMaxInactiveInterval() %></li> //마지막 바인딩된 시간 이후로 (한번도 안됐다면 ) 
<li>session 객체 마지막바인딩시간 : <%=session.getLastAccessedTime() %></li>

</ol>

</body>
</html>