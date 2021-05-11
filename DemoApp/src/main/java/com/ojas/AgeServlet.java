package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ageCheck")
public class AgeServlet extends HttpServlet {
	
	private static final long SerialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method has Started");
	}
	
	public void destroy() {
		System.out.println("Destroy method");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("age"));
		
		if(age > 18) {
			pw.println("<h1 style=color:green> Welcome To Fassion Show </h1>");
		}
		else {
			pw.println("<h1 style=color:red> Welcome to Cartoon Show </h1>");
		}

	}

}
