package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/ConfigDemo" }, 
		initParams = { 
				@WebInitParam(name = "cnames", value = "Java,.Net,Testing,Oracle")
		})
public class ConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    String cnames = null;
    
    public ConfigDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		cnames = config.getInitParameter("cnames");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        pw.println("<html><body bgcolor=wheat text = blue>");
        pw.println("<form action=ConfigDemo method=Post>");
        pw.println("<h1 style=color:maroon>Online courses </h1></hr>");
        pw.println("<p> Select course names </p>");
        pw.println("<p><select name=cname>");
        String[] cn = cnames.split(",");
        for (String string : cn) {
        	pw.println("<option>" +string+ "</option>");
			
		}
        pw.println("</select></p>");
        pw.println("<p><input type=submit value=Register></p>");
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        String[] cs = {"Java",".Net","Testing","Oracle"};
        double prices[] = {25000.0,18000.0,15000.0,20000.0};
        String cname = request.getParameter("cnames");
        int ind = 0;
        for (int i = 0; i < cs.length; i++) {
        	if(cname.equalsIgnoreCase(cs[i])) {
        		ind = i;
        	}
			
		}
        pw.println("<h1 style=color:green> Your Selected course name : +cname +<br>");
        pw.println("You have to Pay "+prices[ind]+"Rs. Only/-</h1>");
        pw.println("<h4 style=color:red> Thank You</h4>");
        
        
        
	}

}
