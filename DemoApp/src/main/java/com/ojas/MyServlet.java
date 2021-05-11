package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/MyServlet")
public class MyServlet extends GenericServlet {
	
	private static final long SerialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	public void destroy() {
		
	}
	

	@Override
	public void service(ServletRequest request, ServletResponse responce) throws ServletException, IOException {
		responce.setContentType("text/html");
		PrintWriter pw = responce.getWriter();
		pw.println("<h1 style-background-color:red; color:white> WELCOME </h1>");
		pw.close();

	}

}
