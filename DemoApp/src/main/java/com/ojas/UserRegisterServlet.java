package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.dao.PersonDao;
import com.ojas.model.Persons;

/**
 * Servlet implementation class UserRegServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
     
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    PersonDao personDao;
	    public UserRegisterServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	 

	    /**
	     * @see Servlet#init(ServletConfig)
	     */
	    public void init(ServletConfig config) throws ServletException {
	        // TODO Auto-generated method stub
	        personDao = new PersonDao();
	    }

	 
	    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	        String ename = request.getParameter("ename");
	        String contactno = request.getParameter("contactno");
	        String email = request.getParameter("email");
	        String gendar = request.getParameter("gendar");
	        String address = request.getParameter("address");
	        System.out.println(gendar);
	        Persons per = new Persons();
	        per.setEname(ename);
	        per.setContactno(contactno);
	        per.setEmail(email);
	        per.setGendar(gendar);
	        per.setAddress(address);
	        
	        if(personDao.addPerson(per)) {
	            pw.println(
	                    "<h1 style=background-color:maroon;solor:white;padding:20px;text-align:center;>your registration has done successfully</h1>");
	        }
	        else {
	            pw.println("<h1 style=color:red> try again</h1>");
	        }
	    }

}
