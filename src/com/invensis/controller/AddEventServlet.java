package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invensis.dao.AddEvent;


@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	AddEvent ae = new AddEvent();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("Name");
		String Price = request.getParameter("price");
		String result = "";

		try {
			result = ae.Add(Name, Price); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().write(result);
		PrintWriter out = response.getWriter();
		if(result.equalsIgnoreCase("Success")) {
			response.sendRedirect("DisplayEventsDetailsServlet");
		}
		else {
			response.sendRedirect("AddEventsDetails.html");
		}
	}


}
