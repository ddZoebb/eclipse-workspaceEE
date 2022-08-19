<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Car"%>
<%@page import="com.itwill.bean.User"%>
<%@page import="com.itwill.bean.Guest"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Car c = new Car(1, "TESLAR", "RED");

Student s=new Student(1000,"학생",new Car(1234,"AAA","whte"));


Guest g = new Guest(100, "백백백","2000/03","guest@gmail.com","www","title","content");
User u=new User("guard","1111","이름","guard@naver.com");
Date d=new Date();

request.setAttribute("car", c);
request.setAttribute("guest", g);
request.setAttribute("user", u);
request.setAttribute("date", d);
request.setAttribute("student", s);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL Bean객체의 property(멤버변수)출력</h1>
	<hr />
	<ul>
<li>${car}</li>
<li>${car.getNo() }</li>
<li>${car.no }</li>
<li>${car.model }</li>
<li>${student }
<li>${student.name }
<li>${student.car }
<li>${student.car.no }
<li>${guest.guest_name }
<li>${user }
<li>${user.userId }
<li>${date }
<li>${date.getYear()+1900 }
<li>${date.year+1900 }년
<li>${date.month+1 }월
	</ul>
</body>
</html>