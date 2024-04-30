package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invensis.dao.DisplayEventsDetails;
import com.invensis.model.Events;

@WebServlet("/DisplayEventsDetailsServlet")
public class DisplayEventsDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DisplayEventsDetails ded = new DisplayEventsDetails();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Events> e = ded.book();
			PrintWriter pw = response.getWriter();
			String htmlResponse="<html><table border='1'><tr><th>Id</th><th>Event Name</th><th>Event Price</th><th>Update</th><th>Delete</th></tr>";

			for(Events event:e) {
				System.out.println(event.toString());
				htmlResponse += "<tr><td>"+event.getEventId()+"</td><td>"+event.getEventName()+"</td><td>"+event.getEventPrice()+"</td>";
				htmlResponse += "<td><a href = 'EventUpdate.html?id= " + event.getEventId()+ "&eventname=" + event.getEventName() + "&eventprice=" +event.getEventPrice()+"'>Update</a></td>";
				htmlResponse += "<td><a href = 'EventDeleteServlet?id= " + event.getEventId()+"'>Delete</a></td></tr>";
				
				System.out.println(htmlResponse);
			}
			htmlResponse +="</table></html>";
			
			pw.println(htmlResponse);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
