package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloTextServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain;charset=UTF-8"); // 응답의 헤더 세팅
		PrintWriter out = response.getWriter(); // 버퍼에 저장
		for (int i = 1; i < 4; i++) {
			out.println("Hello text[dynamic resource1] !!! " + i);
		} // 바디
		return;
	} // 쓰레드 반환 = service를 호출한 컨테이너에게 => 반환 후에 라인 - 헤더 - 바디 순으로 쏴줌...  

}
