package com.invensis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.invensis.model.Events;

public class UsersBookingDetails {
    public List<Events> event() throws SQLException {
        ResultSet rs = null;
        List<Events> Event = new ArrayList<Events>();
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hari", "root", "Hari");
            pst = con.prepareStatement("select * from userbook");
            rs = pst.executeQuery();
            while (rs.next()) {
                Events e = new Events();
                e.setUserId(rs.getString(1));
                e.setUName(rs.getString(2));
                e.setUserPrice(rs.getString(3));
                e.setUserName(rs.getString(4));
                e.setUserMobile(rs.getString(5));
                e.setUserdate(rs.getString(6));
                Event.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return Event;
    }
}
