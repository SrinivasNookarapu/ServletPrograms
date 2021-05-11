package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextDemo
 */
@WebServlet("/ContextDemo")
public class ContextDemo extends HttpServlet {
	 private static final long serialVersionUID = 1L;
     
	 ServletContext context = null;
	     
	    public void init(ServletConfig config) throws ServletException {
	    	context = config.getServletContext();
	    }
	
	  
	    
	    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter pw=response.getWriter();
	        String driver = context.getInitParameter("driver");
	        String url = context.getInitParameter("url");
	        String user = context.getInitParameter("user");
	        String password = context.getInitParameter("password");
	        
	        pw.println("<h3 style=color:blue>Driver Name : " + driver + "</h3>");
	        pw.println("url="+ url +"<br>");
	        pw.println("User Name="+ user +"<br>");
	        pw.println("Password="+ password +"<br>");
	    }
	    }