package com.invensis.dao;

import java.sql.*;

public class BookPage {
	public String Add(String Id, String Name, String Price, String UserName, String Mobile, String Date) throws ClassNotFoundException {
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hari", "root", "Hari");
			PreparedStatement pst = con.prepareStatement("Insert into userbook values(?,?,?,?,?,?)");
			pst.setString(1, Id);
			pst.setString(2, Name);
			pst.setString(3, Price);
			pst.setString(4, UserName);
			pst.setString(5, Mobile);
			pst.setString(6, Date);
			
			i = pst.executeUpdate();
			
		} 
		catch (SQLException e) {
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
