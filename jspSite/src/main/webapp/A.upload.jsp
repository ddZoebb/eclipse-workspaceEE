<%--@page import="com.oreilly.servlet.MultipartRequest"--%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("A.file_upload.jsp");
}
//javax.servlet.http.HttpServletRequest request, java.lang.String saveDirectory, int maxPostSize, java.lang.String encoding
String saveDirectory="C:/upload";	
int maxPostSize=1024*1024*100;
String encoding="UTF-8";

/*
DefaultFileRenamePolicy : 똑같은 이름 가진 파일이 존재한다면 파일명(숫자) 붙여서 저장
FileRenamePolicy : 똑같은 이름 가진 파일이 존재한다면 사용자가 만든 이름 적용시켜줌
*/

MultipartRequest multipartRequest=
new MultipartRequest(request,saveDirectory,maxPostSize,encoding,new DefaultFileRenamePolicy());

/*
원래 request.getParameter 방식으로는
파라메타가존재하지않는다
*/
String name= multipartRequest.getParameter("name");
String fileone= multipartRequest.getParameter("fileone");
String filetwo= multipartRequest.getParameter("filetwo");
%>
<h1>Upload Data</h1>
<hr/>
<br/>
<br/>
<br/>
<li>name:<%=name %></li>
<li>fileone:<%=fileone %></li>
<li>filetwo:<%=filetwo %></li>
