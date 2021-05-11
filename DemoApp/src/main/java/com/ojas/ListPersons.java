package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.dao.PersonDao;
import com.ojas.model.Persons;

/**
 * Servlet implementation class ListPersons
 */
@WebServlet("/ListPersons")
public class ListPersons extends HttpServlet {
	 private static final long serialVersionUID = 1L;
     
	   
	    PersonDao personDao1;
	    public void init(ServletConfig config) throws ServletException {
	        // TODO Auto-generated method stub
	        personDao1 = new PersonDao();
	    }

	    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        
	        response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	          List<Persons> list=personDao1.listPersons();
	          pw.println("<html><head><style type=text/css>");
	          pw.println("table{width:50%;border-collapse:collapse;");
	          pw.println("background-color:wheat;border-spacing:10px;}");
	          pw.println("table,tr,td{border:1px solid blue;}");
	          pw.println("th,td{padding:20px;}");
	          pw.println("</style></head><body>");
	          pw.println("<form action=#>");
	          pw.println("<h1 style=background-color:maroon;color:white;padding:20px;");
	          pw.println("text-align:center;ListPersons</h1>");
	          pw.println("<table align=center>");
	          pw.println("<tr>");
	          for(Persons p : list) {
	              int num = p.getPid();
	              String ename = p.getEname();
	              String contactno = p.getContactno();
	              String email = p.getEmail();
	              String gendar = p.getGendar();
	              String address = p.getAddress();
	              
//	              pw.println("<td>"+p.getPid()+"</td>");
	              pw.println("<td>"+num+"</td>");
	              pw.println("<td>"+p.getEname()+"</td>");
	              pw.println("<td>"+p.getContactno()+"</td>");
	              pw.println("<td>"+p.getEmail()+"</td>");
	              pw.println("<td>"+p.getGendar()+"</td>");
	              pw.println("<td>"+p.getAddress()+"</td>");
	              pw.println("<td><a href=DelServlet?no="+num+">delete</a></td>");
	              pw.println("<td><a href=UpdateServlet?no="
	            		  +num+"&ename="+ename+"&contactno="+contactno+"&email="
	            		  +email+"&gendar="+gendar+"&address="+address+">update</a></td>");
	              pw.println("</tr>");
	          }
	          pw.println("</table></form></body></html>");
	        
	    }

}
