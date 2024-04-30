package com.invensis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register {
	public String Add(String Name, String SurName, String mobile, String email, String password,String role) {
int i = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hari","root","Hari");
			PreparedStatement pst = con.prepareStatement("insert into eventregister (Name, LastName, Mobile, Email, Password, Role) values(?,?,?,?,?,?)");
			pst.setString(1, Name);
			pst.setString(2, SurName);
			pst.setString(3, mobile);
			pst.setString(4, email);
			pst.setString(5, password);
			pst.setString(6, role);
			i= pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}
}
