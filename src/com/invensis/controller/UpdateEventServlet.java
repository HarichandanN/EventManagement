package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invensis.dao.UpdateEvent;


@WebServlet("/UpdateEventServlet")
public class UpdateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	UpdateEvent up = new UpdateEvent();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String Name = request.getParameter("Name");
		String Price = request.getParameter("price");
		String result = "";

		try {
			result = up.update(id, Name, Price);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().write(result);
		PrintWriter out = response.getWriter();
		if(result.equalsIgnoreCase("Success")) {
			response.sendRedirect("EventUpdate.html");
		}
		else {
			response.sendRedirect("EventUpdate.html");
		}
	}

}


