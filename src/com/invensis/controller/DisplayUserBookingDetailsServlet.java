package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.invensis.dao.DisplayUserBookingDetails;
import com.invensis.model.Events;

@WebServlet("/DisplayUserBookingDetailsServlet")
public class DisplayUserBookingDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    DisplayUserBookingDetails dbd = new DisplayUserBookingDetails();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            List<Events> e = dbd.event(username);
            PrintWriter pw = response.getWriter();
            String htmlResponse = "<html><table border='1'><tr><th>Id</th><th>Event Name</th><th>Event Price</th><th>Name</th><th>Mobile</th><th>Date</th></tr>";
            
            
            for (Events event : e) {
                htmlResponse += "<tr><td>" + event.getUserId() + "</td><td>" + event.getUName() + "</td><td>"+ event.getUserPrice() + "</td><td>"+ event.getUserName()+"</td><td>"+event.getUserMobile()+"</td><td>"+event.getUserdate()+"</td></tr>";      
            }
            htmlResponse += "</table></html>";
            pw.println(htmlResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
