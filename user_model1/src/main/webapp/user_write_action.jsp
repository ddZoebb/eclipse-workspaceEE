<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("user_main.jsp");
	return;
}

//request.setCharacterEncoding("UTF-8");
String userId = request.getParameter("userId");
String password = request.getParameter("password");
String name = request.getParameter("name");
String email = request.getParameter("email");

UserService userService = new UserService();
User user = new User(userId, password, name, email);

int check = userService.create(user);
if (check == -1) {
	/*##################아이디중복#################*/
	/*String msg=userId+" 는 이미 존재하는 아이디입니다.";
	msg=URLEncoder.encode(msg,"UTF-8");
	userId=URLEncoder.encode(userId,"UTF-8");
	password=URLEncoder.encode(password,"UTF-8");
	name=URLEncoder.encode(name,"UTF-8");
	email=URLEncoder.encode(email,"UTF-8");
	
	String queryString ="msg="+msg+"&userId="+userId+"&password="+password+"&name="+name+"&email="+email;
	*/

	/*case 1 script
	
	out.println("<script>");
	out.println("alert('"+userId+"는 이미 존재하는 아이디입니다.');" );
	out.println("location.href='user_write_form.jsp?"+queryString+"';");
	out.println("</script>");
	***/

	/*case 2 redirect */
	/*response.sendRedirect("user_write_form.jsp?"+queryString);*/

	/*case3 forward*/
	String msg = userId + "는 이미 존재하는 아이디입니다.";
	request.setAttribute("fuser", user);
	request.setAttribute("msg", msg);

	RequestDispatcher rd = request.getRequestDispatcher("user_write_form.jsp");
	rd.forward(request, response);

} else if (check == 1) {
	/*##################회원가입성공#################*/
	response.sendRedirect("user_login_form.jsp");

}
%>















