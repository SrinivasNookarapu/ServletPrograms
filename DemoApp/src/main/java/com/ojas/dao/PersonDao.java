package com.ojas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ojas.model.Persons;

public class PersonDao {
	Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srinu","root","root");
			System.out.println("Connected");
		} 
		catch (Exception e) {
			
			System.out.println(e);
		}
		return con;
		
	}
	
	public boolean addPerson(Persons person) {
	    boolean b=false;
	    try{
	        Connection con=getConnect();
	        PreparedStatement pst=con.prepareStatement("insert into persons"+"(ename,contactno,email,gendar,address)"+"values(?,?,?,?,?)");
	        pst.setString(1, person.getEname());
	        pst.setString(2, person.getContactno());
	        pst.setString(3, person.getEmail());
	        pst.setString(4,person.getGendar());
	        pst.setString(5,person.getAddress());
	        int res=pst.executeUpdate();
	        
	        if(res>0){
	            b=true;
	           
	        }
	       
	    }
	    catch(Exception e){
	        System.out.println(e);
	    }
		return b;
	        
	        
	    }
	
	public List<Persons> listPersons(){
		List<Persons> list = new ArrayList<>();
		try {
			Connection con = getConnect();
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from persons");
			while(res.next()) {
				Persons p = new Persons(res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6));
				list.add(p);
			}
			res.close();
			st.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public boolean validate(String uname, String psw) {
		boolean b = false;
		
		try {
			Connection con = getConnect();
			PreparedStatement pst = con.prepareStatement("select * from persons where ename=? and contactno=?");
			pst.setString(1, uname);
			pst.setString(2, psw);
			
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				b = true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
		
		
		return b;
	}
	
	public boolean delPerson(int num) {
		boolean b = false;
		try {
			Connection con = getConnect();
			PreparedStatement pst = con.prepareStatement("delete from persons where pid = ?");
			pst.setInt(1, num);
			int res = pst.executeUpdate();
			
			if(res > 0) {
				b = true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
		return b;
	}

	public boolean updatePerson(Persons person) {
		
		 boolean b = false;
		    try {
		        Connection con = getConnect();
		        PreparedStatement pst = con
		                .prepareStatement("update persons set ename=?,contactno=?,email=?,gendar=?,address=? where pid=?");
		        pst.setString(1, person.getEname());
		        pst.setString(2, person.getContactno());
		        pst.setString(3, person.getEmail());
		        pst.setString(4, person.getGendar());
		        pst.setString(5, person.getAddress());
		        pst.setInt(6, person.getPid());
		        int res = pst.executeUpdate();
		        if (res > 0) {
		            b = true;
		        }
		    } catch (Exception e) {
		        System.out.println(e);
		    }
		    return b;
				

	}

}
