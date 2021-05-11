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

import com.ojas.dao.PersonDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long SerialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method has Started");
	}
	
	public void destroy() {
		System.out.println("Destroy method");
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		PersonDao personDao = new PersonDao();
		
		if(personDao.validate(uname, upass)) {
			res.sendRedirect("./ListPersons");
		}
		else {
			pw.println("<h2 style=color:red> Try Again </h2>");
		}
		

	}

}
