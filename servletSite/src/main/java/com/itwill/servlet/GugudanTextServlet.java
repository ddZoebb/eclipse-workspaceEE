package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GugudanTextServlet extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 메소드 호출");
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("GuguDan dynamic resource");
		out.println("-------------------------");
		for(int i=1;i<10;i++) {
			for(int j=2;j<10;j++) {
				out.print(j+"*"+i+"="+ i*j+"\t");
				if(j==9) {
					out.println();
				}
				
			}
		}
		
		
	}

}
