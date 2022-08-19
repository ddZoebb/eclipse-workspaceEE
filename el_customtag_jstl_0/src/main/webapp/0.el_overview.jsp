<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.bean.User"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/****************String,Wrapper 속성객체 ****************************/
request.setAttribute("a", new String("속성객체"));
request.setAttribute("b", new Integer(2));
request.setAttribute("c", new Boolean(true));
request.setAttribute("d","속성객체2");
request.setAttribute("e", 3); //auto boxing
request.setAttribute("f", false); //auto boxing 


/****************자바 빈 속성객체 ****************************/
request.setAttribute("guest", new Guest(1,"KIM","2022/03","111@naver.com","www.naver.com","title","content"));
request.setAttribute("user", new User("id","1111","name","1@NAVER.COM"));

/********************List(array),Map 속성객체**************************/
List<Guest> guestList=new ArrayList<Guest>();
guestList.add(new Guest(12,"AIM","2022/03","1211@naver.com","www.naver.com","title1","content1"));
guestList.add(new Guest(13,"DIM","2022/03","1311@naver.com","www.naver.com","title2","content2"));
guestList.add(new Guest(14,"FIM","2022/03","1411@naver.com","www.naver.com","title3","content3"));

/***************************Map 속성객체************************************/
request.setAttribute("guestList", guestList);
Map<String,Guest> guestMap=new HashMap<String,Guest>();
guestMap.put("g1",new Guest(15,"GIM","2022/03","1131@naver.com","www.naver.com","title4","content4"));
guestMap.put("g2",new Guest(16,"HIM","2022/03","1114@naver.com","www.naver.com","title5","content5"));
guestMap.put("g3",new Guest(17,"JIM","2022/03","1151@naver.com","www.naver.com","title6","content6"));
request.setAttribute("guestMap", guestMap);

/***************JSP local 변수*****************/
String str1="jsp local ";
int int1=1234;
User user1=new User("KANG","222","2022-03","kang@naver.com");


/*
속성(attribute) 객체
- 속성객체이름: a,b,c,d,e.......
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<ul>
		<li>NO EL(el 사용하지 않았을 때)</li>
		<li><%=request.getAttribute("a") %></li>
		<li><%=request.getAttribute("b") %></li>
		<li><%=request.getAttribute("c") %></li>
		<li><%=request.getAttribute("d") %></li>
		<li><%=request.getAttribute("guest") %></li>
		<li><%=((Guest)request.getAttribute("guest")).getGuest_name() %></li>
		<li>-----------------List-----------------</li>
		<li><%= request.getAttribute("guestList")%></li>
		<li><%= ((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_email()%></li>
		<li>-----------------Map-----------------</li>
		<li><%=((Map<String,Guest>)request.getAttribute("guestMap")).get("g1").getGuest_content() %></li>
		
		<li><%=str1 %></li>
		
		<li>***************EL*******************</li>
		<li>${a}</li>
		<li>${b}</li>
		<li>${c}</li>
		<li>${d}</li>
		<li>${e}</li>
		<li>${f}</li>
		
		<li>${guest.getGuest_email()}</li>
		
		<li>${guestList[0].guest_no }</li>
		
		<li>${guestMap.g1.guest_no}</li>
		<li>${guestMap["g1"].guest_name}</li>
		
		<li>--JSP service 안에 선언된 local 변수 EL로는 출력 불가능 --</li>
		<li>${str1}</li>
		
	</ul>
</body>
</html>