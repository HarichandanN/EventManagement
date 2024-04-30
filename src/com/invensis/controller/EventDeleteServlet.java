package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invensis.dao.DeleteEvent;



@WebServlet("/EventDeleteServlet")
public class EventDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	DeleteEvent del = new DeleteEvent();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String result = "";

		try {
			result = del.delete(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().write(result);
		PrintWriter out = response.getWriter();
		if(result.equalsIgnoreCase("Success")) {
			out.println("Your New Record Will be added Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("DisplayEventsDetailsServlet");
			rd.forward(request,response);
		}
		else {
			out.println("your entering invalid details!");
			RequestDispatcher rd=request.getRequestDispatcher("DisplayEventsDetailsServlet");
			rd.forward(request, response);
		}
	}

}



