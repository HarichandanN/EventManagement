package com.invensis.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.invensis.model.Events;


public class DisplayEventsDetails {
	public List<Events> book() throws SQLException {

		ResultSet rs = null;
		List<Events> Event = new ArrayList<Events>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hari","root","Hari");
			PreparedStatement pst = con.prepareStatement("select * from event");
			rs = pst.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		while(rs.next()) {
			Events e = new Events();
			e.setEventId(rs.getString(1));
			e.setEventName(rs.getString(2));
			e.setEventPrice(rs.getString(3));
			Event.add(e);

		} 
		return Event;
	}
}
