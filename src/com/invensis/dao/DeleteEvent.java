package com.invensis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteEvent {
	public String delete(String id) {

		int i = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hari","root","Hari");
			PreparedStatement pst = con.prepareStatement("delete from event WHERE Id = ?");
			pst.setString(1, id);
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

