<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 
    
    int point=Integer.parseInt(request.getParameter("point"));
    int tot=Integer.parseInt(request.getParameter("changeTot"));
    tot-=point;
    request.setAttribute("price",tot);
    RequestDispatcher rd=request.getRequestDispatcher("order_form_test.jsp");
    rd.forward(request, response);
   
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>