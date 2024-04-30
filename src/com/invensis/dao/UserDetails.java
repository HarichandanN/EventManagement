package com.invensis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.invensis.model.Events;

public class UserDetails {
	public List<Events> book() throws SQLException {

		ResultSet rs = null;
		List<Events> Event = new ArrayList<Events>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hari","root","Hari");
			PreparedStatement pst = con.prepareStatement("select * from eventregister");
			rs = pst.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		while(rs.next()) {
			Events e = new Events();
			e.setId(rs.getString(1));
			e.setName(rs.getString(2));
			e.setLastName(rs.getString(3));
			e.setMobile(rs.getString(4));
			e.setEmail(rs.getString(5));
			e.setPassword(rs.getString(6));
			Event.add(e);

		} 
		return Event;
	}
}
