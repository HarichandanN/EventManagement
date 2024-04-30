package com.invensis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEvent {
	public String update(String id,String Name,String Price) {

		int i = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hari","root","Hari");
			PreparedStatement pst = con.prepareStatement("UPDATE event SET EventName = ?, EventPrice = ? WHERE Id = ?");
			pst.setString(1, Name);
			pst.setString(2, Price);
			pst.setString(3, id);
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
