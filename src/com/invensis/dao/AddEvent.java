package com.invensis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddEvent {
	public String Add(String Name,String Price) {

		int i = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hari","root","Hari");
			PreparedStatement pst = con.prepareStatement("insert into event (EventName, EventPrice) values(?,?)");
			pst.setString(1, Name);
			pst.setString(2, Price);
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
